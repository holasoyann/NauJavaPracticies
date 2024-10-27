package ru.nikitina.NauJava.services;

import ru.nikitina.NauJava.entities.Log;
import ru.nikitina.NauJava.entities.LoggingLevel;

import java.util.Date;

public interface LogService {
    void createLog(Long id, Date timestamp, LoggingLevel loggingLevel, String message);

    Log findById(Long id);

    void deleteById(Long id);

    void updateLog(Long id, Date timestamp, LoggingLevel loggingLevel, String message);
}
