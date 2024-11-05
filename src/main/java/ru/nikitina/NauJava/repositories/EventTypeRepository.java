package ru.nikitina.NauJava.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.nikitina.NauJava.entities.EventType;

public interface EventTypeRepository extends CrudRepository<EventType, Long> {
}
