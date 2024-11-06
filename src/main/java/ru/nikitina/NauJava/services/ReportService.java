package ru.nikitina.NauJava.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nikitina.NauJava.entities.Log;
import ru.nikitina.NauJava.entities.ReportStatus;
import ru.nikitina.NauJava.repositories.LogRepository;
import ru.nikitina.NauJava.repositories.ReportRepository;
import ru.nikitina.NauJava.repositories.UserRepository;

import ru.nikitina.NauJava.entities.Report;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicLong;

@Service
@RequiredArgsConstructor
public class ReportService {
    private final ReportRepository reportRepository;
    private final UserRepository userRepository;
    private final LogRepository logRepository;

    public Long createReport() {
        Report report = new Report();
        report = reportRepository.save(report);
        return report.getId();
    }

    public Report getReport(Long reportId) {
        return reportRepository.findById(reportId).orElse(null);
    }

    public void generateReport(Long reportId) {
        Report report = reportRepository.findById(reportId).orElse(null);
        if (report == null) return;
        CompletableFuture.runAsync(() -> {
            try {
                long totalStartTime = System.currentTimeMillis();
                var userCountTime = new AtomicLong();
                CompletableFuture<Integer> userCountFuture = CompletableFuture.supplyAsync(() -> {
                    var startTime = System.currentTimeMillis();
                    var userCount = (int) userRepository.count();
                    userCountTime.set(System.currentTimeMillis() - startTime);
                    System.out.println("User count time: " + (System.currentTimeMillis() - startTime) + "ms");
                    return userCount;
                });
                AtomicLong logListTime = new AtomicLong();
                CompletableFuture<List<Log>> logListFuture = CompletableFuture.supplyAsync(() -> {
                    long startTime = System.currentTimeMillis();
                    List<Log> logList = (List<Log>) logRepository.findAll();
                    logListTime.set(System.currentTimeMillis() - startTime);
                    System.out.println("Log list time: " + (System.currentTimeMillis() - startTime) + "ms");
                    return logList;
                });
                int userCount = userCountFuture.join();
                List<Log> logList = logListFuture.join();
                StringBuilder content = new StringBuilder();
                content.append("<html><body><h1>Report</h1>");
                content.append("<p>User Count: ").append(userCount).append("</p>");
                content.append("<p>Time for user count: ").append(userCountTime).append(" ms</p>");
                content.append("<p>Log List:</p><ul>");
                for (var log : logList) {
                    content.append("<li>").append(log.toString()).append("</li>");
                }
                content.append("</ul>");
                content.append("<p>Time for log list: ").append(logListTime).append(" ms</p>");
                content.append("<p>Total generation time: ")
                        .append(System.currentTimeMillis() - totalStartTime).append("ms</p>");
                content.append("</body></html>");
                report.setContent(content.toString());
                report.setStatus(ReportStatus.COMPLETED);
            } catch (Exception e) {
                report.setStatus(ReportStatus.ERROR);
                report.setContent("Error generating report: " + e.getMessage());
            } finally {
                reportRepository.save(report);
            }
        });
    }
}