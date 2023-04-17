package com.example.projet_pfa.repository;

import com.example.projet_pfa.entity.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZoneRepository extends JpaRepository<Zone,Integer> {
    public Zone findById(int id);
}
