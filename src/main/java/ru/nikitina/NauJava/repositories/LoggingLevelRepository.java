package ru.nikitina.NauJava.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.nikitina.NauJava.entities.LoggingLevel;

@RepositoryRestResource(path="loggingLevels")
public interface LoggingLevelRepository extends CrudRepository<LoggingLevel, Long> {
}
