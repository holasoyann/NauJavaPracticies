package ru.nikitina.NauJava.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.nikitina.NauJava.entities.LoggingLevel;

public interface LoggingLevelRepository extends CrudRepository<LoggingLevel, Long> {
}
