package com.hillel.multi.persistent.repository;

import com.hillel.multi.persistent.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
    Optional<User> findByUsernameAndPassword(String username, String password);

    Optional<User> findByToken(String token);
}