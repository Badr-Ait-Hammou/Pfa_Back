package com.example.projet_pfa.service;

import com.example.projet_pfa.dao.Dao;
import com.example.projet_pfa.entity.Zone;
import com.example.projet_pfa.repository.ZoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ZoneService implements Dao<Zone> {
   @Autowired
    private ZoneRepository zoneRepository;
    @Override
    public Zone save(Zone o) {
        return this.zoneRepository.save(o);
    }

    @Override
    public List<Zone> findAll() {
        return this.zoneRepository.findAll();
    }

    @Override
    public Zone findById(int id) {
        return this.zoneRepository.findById(id);
    }

    @Override
    public void delete(Zone o) {
      this.zoneRepository.delete(o);
    }
}
