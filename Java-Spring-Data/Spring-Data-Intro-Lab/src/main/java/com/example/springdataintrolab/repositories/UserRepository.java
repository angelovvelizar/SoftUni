package com.example.springdataintrolab.repositories;

import com.example.springdataintrolab.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User getByUsername(String username);

    boolean existsByUsername(String username);

}
