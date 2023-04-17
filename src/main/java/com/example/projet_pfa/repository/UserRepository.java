package com.example.projet_pfa.repository;

import com.example.projet_pfa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findById(int id);
}
