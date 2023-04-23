package com.example.projet_pfa.service;

import com.example.projet_pfa.dao.Dao;
import com.example.projet_pfa.entity.User;
import com.example.projet_pfa.entity.Ville;
import com.example.projet_pfa.repository.VilleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VilleService implements Dao<Ville> {
   @Autowired
    private VilleRepository villeRepository;
    @Override
    public Ville save(Ville ville) {
        return this.villeRepository.save(ville);
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
    public void delete(Ville ville) {
      this.villeRepository.delete(ville);
    }
    public void deleteVille(Integer id){
        Ville ville = villeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("user not found with id " + id));
        villeRepository.delete(ville);
    }
}
