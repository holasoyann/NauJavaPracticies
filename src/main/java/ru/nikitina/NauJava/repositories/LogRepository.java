package ru.nikitina.NauJava.repositories;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import ru.nikitina.NauJava.entities.Log;

import java.util.List;

@Component
public class LogRepository implements CrudRepository<Log, Long> {
    private final List<Log> logContainer;

    @Autowired
    @Lazy
    public LogRepository(List<Log> logContainer) {
        this.logContainer = logContainer;
    }

    @SneakyThrows
    @Override
    public void create(Log log) {
        var logAlreadyExists =  logContainer.stream().filter(l -> l.getId() == log.getId()).findFirst();
        if (logAlreadyExists.isPresent()) {
            throw new Exception("Error on create: entity already exists");
        }
        logContainer.add(log);
    }

    @Override
    public Log read(Long id) {
        var result =  logContainer.stream().filter(log -> log.getId() == id).findFirst();
        return result.orElseThrow();
    }

    @SneakyThrows
    @Override
    public void update(Log log) {
        var logToUpdate = logContainer.stream().filter(l -> l.getId() == log.getId()).findFirst();
        if (logToUpdate.isPresent()) {
            logContainer.remove(logToUpdate.get());
            logContainer.add(log);
        }
        else {
            throw new Exception("Error on update: Entity does not exist");
        }
    }

    @SneakyThrows
    @Override
    public void delete(Long id) {
        var logToUpdate = logContainer.stream().filter(l -> l.getId() == id).findFirst();
        if (logToUpdate.isPresent()) {
            logContainer.remove(logToUpdate.get());
        }
        else {
            throw new Exception("Error on delete: Entity does not exist");
        }
    }
}
