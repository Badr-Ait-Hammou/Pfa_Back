package com.example.projet_pfa.repository;

import com.example.projet_pfa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {


}
