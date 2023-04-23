package com.example.projet_pfa.service;

import com.example.projet_pfa.dao.Dao;
import com.example.projet_pfa.entity.User;
import com.example.projet_pfa.entity.Ville;
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
        return zoneRepository.save(zone);
    }

    @Override
    public List<Zone> findAll() {
       return zoneRepository.findAll();
    }

    @Override
    public Zone findById(int id) {
       return zoneRepository.findById(id);
    }

    @Override
    public void delete(Zone zone) {

    }
    public void deleteZone(Integer id){
        Zone zone = zoneRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("user not found with id " + id));
        zoneRepository.delete(zone);
    }
    public void update(Integer id, Zone zoneinfo) {
        Zone zone=zoneRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("zone not found with id " + id));
        zone.setNom(zoneinfo.getNom());
        zone.setVille(zoneinfo.getVille());
        zoneRepository.save(zone);
    }
}
