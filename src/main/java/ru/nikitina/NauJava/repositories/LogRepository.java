package ru.nikitina.NauJava.repositories;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.nikitina.NauJava.entities.Log;


public interface LogRepository extends CrudRepository<Log, Long> {
    @Query("SELECT l FROM Log l WHERE l.loggingLevel.name = :loggingLevel")
    List<Log> findByLoggingLevel(@Param("loggingLevel") String loggingLevel);

    List<Log> findBySourceAndTimestamp(String source, Date timestamp);
}