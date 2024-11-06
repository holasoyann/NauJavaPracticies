package ru.nikitina.NauJava.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.nikitina.NauJava.entities.Role;

import java.util.List;

@RepositoryRestResource(path="roles")
public interface RoleRepository extends CrudRepository<Role, Long> {
    List<Role> findByName(String roleName);
}
