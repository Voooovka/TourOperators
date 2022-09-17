package com.javovka.touragency.repository;

import com.javovka.touragency.model.Role;
import com.javovka.touragency.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {
}
