package com.nigma.springJWT.service;

import com.nigma.springJWT.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    List<User> findAll();
    User createUser(User user);
}
