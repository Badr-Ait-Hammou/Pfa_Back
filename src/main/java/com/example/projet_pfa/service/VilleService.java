package com.example.projet_pfa.service;

import com.example.projet_pfa.dao.Dao;
import com.example.projet_pfa.entity.Ville;
import com.example.projet_pfa.repository.VilleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VilleService implements Dao<Ville> {
   @Autowired
    private VilleRepository villeRepository;
    @Override
    public Ville save(Ville o) {
        return this.villeRepository.save(o);
    }

    @Override
    public List<Ville> findAll() {
        return this.villeRepository.findAll();
    }

    @Override
    public Ville findById(int id) {
        return this.villeRepository.findById(id);
    }

    @Override
    public void delete(Ville o) {
      this.villeRepository.delete(o);
    }
}
