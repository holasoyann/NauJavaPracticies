package ru.nikitina.NauJava.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.nikitina.NauJava.entities.Role;
import ru.nikitina.NauJava.entities.User;
import ru.nikitina.NauJava.repositories.RoleRepository;
import ru.nikitina.NauJava.repositories.UserRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<User> findAll() {
        return StreamSupport.stream(userRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void addUser(User user) {
        addUser(user.getUsername(), user.getPassword(), "ADMIN");
    }

    @Override
    @Transactional
    public void addUser(String username, String password, String roleName) {
        if (!userRepository.findByUsername(username).isEmpty()) {
            System.out.println("User with name " + username + " already exists");
            return;
        }
        Role role;
        var roles = roleRepository.findByName(roleName);
        if (roles.isEmpty()) {
            role = new Role(roleName);
            roleRepository.save(role);
        }
        else {
            role = roles.getFirst();
        }
        var encodedPassword = passwordEncoder.encode(password);
        var newUser = new User(username, encodedPassword, role);
        userRepository.save(newUser);
    }

    @Override
    public User getByName(String username) {
        try{
            return userRepository.findByUsername(username).getFirst();
        } catch (Exception e) {
            System.out.println("User witn name " + username +  " not found");
            return null;
        }
    }
}
