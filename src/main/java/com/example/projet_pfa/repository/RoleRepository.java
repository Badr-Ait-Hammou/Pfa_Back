package com.example.projet_pfa.repository;

import com.example.projet_pfa.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Integer> {
    Role findById(int id);
}
