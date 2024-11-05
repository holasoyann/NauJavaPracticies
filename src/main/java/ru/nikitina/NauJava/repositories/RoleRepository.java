package ru.nikitina.NauJava.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.nikitina.NauJava.entities.Role;

import java.util.List;

public interface RoleRepository extends CrudRepository<Role, Long> {
}
