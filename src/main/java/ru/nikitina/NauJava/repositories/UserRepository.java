package ru.nikitina.NauJava.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.nikitina.NauJava.entities.User;

@RepositoryRestResource(path="users")
public interface UserRepository extends CrudRepository<User, Long>
{
    List<User> findByUsername(String username);
}
