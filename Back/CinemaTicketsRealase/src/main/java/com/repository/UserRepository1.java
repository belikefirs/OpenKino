package com.repository;

import com.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository1 extends JpaRepository<User, Long> {
    User findByUsername(String name);
}
