package com.javovka.touragency.service.impl;

import com.javovka.touragency.model.User;
import com.javovka.touragency.repository.UserRepo;
import com.javovka.touragency.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    @Override
    public List<User> gerUsers() {
        return userRepo.findAll();
    }

    @Override
    public User getUser(Long id) {
        return userRepo.findUserById(id);
    }

    @Override
    public User createUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }

    @Override
    public void updateUser(Long id, User user) {
        User newUser = userRepo.findUserById(id);

        newUser.setUsername(user.getUsername());
        newUser.setBitrhdate(user.getBitrhdate());
        newUser.setLastname(user.getLastname());
        newUser.setPassword(user.getPassword());

        userRepo.save(newUser);
    }

}
