package com.example.projet_pfa.repository;

import com.example.projet_pfa.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile,Integer> {
    Profile findById(int id);
Profile findProfileByUserId(int id);}



