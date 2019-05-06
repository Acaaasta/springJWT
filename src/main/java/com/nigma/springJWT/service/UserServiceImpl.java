package com.nigma.springJWT.service;

import com.nigma.springJWT.entity.Role;
import com.nigma.springJWT.entity.User;
import com.nigma.springJWT.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(User user) {
        user.setRoles(Collections.singleton(Role.USER));
        return userRepository.save(user);
    }
}
