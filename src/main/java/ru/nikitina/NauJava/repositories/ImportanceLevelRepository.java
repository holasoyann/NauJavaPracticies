package ru.nikitina.NauJava.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.nikitina.NauJava.entities.ImportanceLevel;

public interface ImportanceLevelRepository extends CrudRepository<ImportanceLevel, Long> {
}
