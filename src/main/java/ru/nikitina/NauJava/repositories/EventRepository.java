package ru.nikitina.NauJava.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.nikitina.NauJava.entities.Event;

import java.util.Date;
import java.util.List;

public interface EventRepository  extends CrudRepository<Event, Long> {
}
