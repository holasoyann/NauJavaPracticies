package ru.nikitina.NauJava.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.nikitina.NauJava.entities.Report;
import ru.nikitina.NauJava.entities.ReportStatus;
import ru.nikitina.NauJava.services.ReportService;

@Controller
public class ReportController {
    private final ReportService reportService;

    @Autowired
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public Long createReport() {
        Long reportId = reportService.createReport();
        reportService.generateReport(reportId);
        return reportId;
    }
    @GetMapping("/{id}")
    public String getReportContent(@PathVariable Long id) {
        Report report = reportService.getReport(id);
        if (report == null) {
            return "Report not found";
        } else if (report.getStatus() == ReportStatus.CREATED) {
            return "Report is still generating";
        } else if (report.getStatus() == ReportStatus.ERROR) {
            return "Error occurred during report generation";
        } else {
            return report.getContent();
        }
    }
}