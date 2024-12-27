package com.scm.services;

import java.util.List;
import java.util.Optional;

import com.scm.entities.User;

public interface UserService {
    User saveUser(User user);
    Optional<User> getUser(String userId);
    Optional<User> updateUser(User user);
    void deletUser(String userId);
    boolean isUserExist(String userId);
    boolean isUserExistByEmail(String email);
    List<User> getAllUsers();





}
