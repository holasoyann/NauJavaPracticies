package ru.nikitina.NauJava.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import ru.nikitina.NauJava.entities.User;

public interface UserRepository extends CrudRepository<User, Long>
{
    List<User> findByUsername(String username);
}
