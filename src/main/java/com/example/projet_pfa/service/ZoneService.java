package com.example.projet_pfa.service;

import com.example.projet_pfa.dao.Dao;
import com.example.projet_pfa.entity.User;
import com.example.projet_pfa.entity.Zone;
import com.example.projet_pfa.repository.ZoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ZoneService implements Dao<Zone> {
   @Autowired
    private ZoneRepository zoneRepository;

    @Override
    public Zone save(Zone zone) {
        return this.zoneRepository.save(zone);
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
    public void delete(Zone zone) {
      this.zoneRepository.delete(zone);
    }
    public void deleteZone(Integer id){
        Zone zone = zoneRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("user not found with id " + id));
        zoneRepository.delete(zone);
    }
}
