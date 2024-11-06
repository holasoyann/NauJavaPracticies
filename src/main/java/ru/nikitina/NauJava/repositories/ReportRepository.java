package ru.nikitina.NauJava.repositories;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.repository.CrudRepository;
import ru.nikitina.NauJava.entities.Report;

@RepositoryRestResource(path="reports")
public interface ReportRepository extends CrudRepository<Report, Long> {
}
