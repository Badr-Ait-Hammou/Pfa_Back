package com.example.projet_pfa.service;

import com.example.projet_pfa.dao.Dao;
import com.example.projet_pfa.entity.Serie;
import com.example.projet_pfa.entity.Specialite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import com.example.projet_pfa.repository.SpecialiteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialiteService implements Dao<Specialite> {

    @Autowired
    private SpecialiteRepository specialiteRepository;

    @Override
    public Specialite save(Specialite specialite) { return this.specialiteRepository.save(specialite);}

    @Override
    public Specialite findById(int id) { return this.specialiteRepository.findById(id);}

    @Override
    public List<Specialite> findAll() { return this.specialiteRepository.findAll();}

    @Override
    public void delete(Specialite o) { this.specialiteRepository.delete(o);}


    public void update(Integer id, Specialite specialiteinfo) {
        Specialite specialite=specialiteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("specialite not found with id " + id));
        specialite.setNom(specialiteinfo.getNom());
        specialiteRepository.save(specialite);
    }

    public void deleteSpecialite(Integer id){
        Specialite specialite = specialiteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("specialite not found with id " + id));
        specialiteRepository.delete(specialite);
    }
}
