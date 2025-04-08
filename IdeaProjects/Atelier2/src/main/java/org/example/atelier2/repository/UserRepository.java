package org.example.atelier2.repository;

import org.example.atelier2.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User , String> {
    User findByUsername(String username);
}
