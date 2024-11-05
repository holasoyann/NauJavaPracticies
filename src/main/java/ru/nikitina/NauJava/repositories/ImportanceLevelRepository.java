package ru.nikitina.NauJava.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.nikitina.NauJava.entities.ImportanceLevel;

@RepositoryRestResource(path="importanceLevels")
public interface ImportanceLevelRepository extends CrudRepository<ImportanceLevel, Long> {
}
