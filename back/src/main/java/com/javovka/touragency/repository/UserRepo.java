package com.javovka.touragency.repository;

import com.javovka.touragency.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {

    User findUserById(Long id);

}
