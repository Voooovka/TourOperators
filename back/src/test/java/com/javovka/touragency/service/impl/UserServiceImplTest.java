package com.javovka.touragency.service.impl;

import com.javovka.touragency.model.Role;
import com.javovka.touragency.model.User;
import com.javovka.touragency.repository.UserRepo;
import com.javovka.touragency.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import javax.xml.crypto.Data;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepo userRepo;

    private UserService userService;

    @BeforeEach
    void setUp(){
        userService = new UserServiceImpl(userRepo);
    }

    @Test
    void updateUser() {
        Long id = 1L;

        User oldUser = new User(1L, "arsen", "zaika", Date.from(Instant.now()), "password", new Role(1L,"USER"));
        User user = new User(1L, "vovka", "kakashka", Date.from(Instant.now()), "password123", new Role(1L,"USER"));

        given(userRepo.findUserById(id)).willReturn(oldUser);

        userService.updateUser(id, user); 

        ArgumentCaptor<User> argumentCaptor = ArgumentCaptor.forClass(User.class);

        Mockito.verify(userRepo).save(argumentCaptor.capture());

        User capturedUser = argumentCaptor.getValue();

        assertThat(capturedUser.getId()).isEqualTo(user.getId()); 
        assertThat(capturedUser.getUsername()).isEqualTo(user.getUsername()); 
        assertThat(capturedUser.getLastname()).isEqualTo(user.getLastname()); 
        assertThat(capturedUser.getBirthdate()).isEqualTo(user.getBirthdate());
        assertThat(capturedUser.getPassword()).isEqualTo(user.getPassword()); 




    }
}