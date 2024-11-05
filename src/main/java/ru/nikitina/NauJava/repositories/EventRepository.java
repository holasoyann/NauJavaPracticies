package ru.nikitina.NauJava.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.nikitina.NauJava.entities.Event;

import java.util.Date;
import java.util.List;

@RepositoryRestResource(path="events")
public interface EventRepository  extends CrudRepository<Event, Long> {
}
