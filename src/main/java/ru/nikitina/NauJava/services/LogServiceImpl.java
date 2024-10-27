package ru.nikitina.NauJava.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import ru.nikitina.NauJava.entities.Log;
import ru.nikitina.NauJava.entities.LoggingLevel;
import ru.nikitina.NauJava.repositories.LogRepository;

import java.util.Date;


@Service
public class LogServiceImpl implements LogService {
    private final LogRepository logRepository;

    @Autowired
    @Lazy
    public LogServiceImpl(LogRepository userRepository) {
        this.logRepository = userRepository;
    }

    @Override
    public void createLog(Long id, Date timestamp, LoggingLevel loggingLevel, String message) {
        var newLog = new Log();
        newLog.setId(id);
        newLog.setTimeStamp(timestamp);
        newLog.setLoggingLevel(loggingLevel);
        newLog.setMessage(message);
        logRepository.create(newLog);
    }

    @Override
    public Log findById(Long id) {
        return logRepository.read(id);
    }

    @Override
    public void deleteById(Long id) {
        logRepository.delete(id);
    }

    @Override
    public void updateLog(Long id, Date timestamp, LoggingLevel loggingLevel, String message) {
        var log = new Log();
        log.setId(id);
        log.setTimeStamp(timestamp);
        log.setLoggingLevel(loggingLevel);
        log.setMessage(message);
        logRepository.update(log);
    }
}