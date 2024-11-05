package ru.nikitina.NauJava.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.nikitina.NauJava.entities.EventType;

@RepositoryRestResource(path="eventTypes")
public interface EventTypeRepository extends CrudRepository<EventType, Long> {
}
