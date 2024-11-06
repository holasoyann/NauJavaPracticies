package ru.nikitina.NauJava.services;

import ru.nikitina.NauJava.entities.User;

import java.util.List;

public interface UserService {
    public List<User> findAll();

    public User findById(Long id);

    public void addUser(User user);

    public void addUser(String username, String password, String roleName);

    public User getByName(String username);
}
