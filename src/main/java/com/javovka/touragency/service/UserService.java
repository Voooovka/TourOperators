package com.javovka.touragency.service;

import com.javovka.touragency.model.User;

import java.util.List;

public interface UserService {

    List<User> gerUsers();
    User getUser(Long id);
    User createUser(User user);
    void deleteUser(Long id);
    void updateUser(Long id, User user);
}
