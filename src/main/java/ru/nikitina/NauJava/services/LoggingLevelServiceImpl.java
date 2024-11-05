package ru.nikitina.NauJava.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import ru.nikitina.NauJava.entities.Log;
import ru.nikitina.NauJava.entities.LoggingLevel;
import ru.nikitina.NauJava.repositories.LogRepository;
import ru.nikitina.NauJava.repositories.LoggingLevelRepository;

@Service
public class LoggingLevelServiceImpl implements LoggingLevelService {
    private final LogRepository logRepository;
    private final LoggingLevelRepository loggingLevelRepository;
    private final PlatformTransactionManager transactionManager;

    @Autowired
    public LoggingLevelServiceImpl(LogRepository logRepository, LoggingLevelRepository loggingLevelRepository, PlatformTransactionManager transactionManager) {
        this.logRepository = logRepository;
        this.loggingLevelRepository = loggingLevelRepository;
        this.transactionManager = transactionManager;
    }

    @Override
    public void deleteLog(Long levelId){
        TransactionStatus status = transactionManager.getTransaction(new
                DefaultTransactionDefinition());
        try
        {
            LoggingLevel level = loggingLevelRepository.findById(levelId).get();
            List<Log> logs = logRepository.findByLoggingLevel(level.getName());
            for (var log : logs)
            {
                logRepository.delete(log);
            }
            loggingLevelRepository.deleteById(levelId);
            transactionManager.commit(status);
        }
        catch (DataAccessException ex)
        {
            transactionManager.rollback(status);
            throw ex;
        }
    }
}
