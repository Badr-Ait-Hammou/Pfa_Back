package com.example.projet_pfa.service;

import com.example.projet_pfa.dao.Dao;
import com.example.projet_pfa.entity.Avis;
import com.example.projet_pfa.entity.User;
import com.example.projet_pfa.entity.Ville;
import com.example.projet_pfa.repository.AvisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvisService implements Dao<Avis> {



    @Autowired
    private AvisRepository avisRepository;

    @Override
    public Avis save(Avis avis) {
        return avisRepository.save(avis);
    }

    @Override
    public List<Avis> findAll() {
        return avisRepository.findAll();
    }

    @Override
    public Avis findById(int id) {
        return avisRepository.findById(id);
    }

    @Override
    public void delete(Avis o) {

    }
    public void deleteAvis(Integer id){
        Avis avis = avisRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("avis not found with id " + id));
        avisRepository.delete(avis);
    }

    public void update(Integer id, Avis avisinfo) {
       Avis avis=avisRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("avis not found with id " + id));
       avis.setNote(avisinfo.getNote());
       avis.setRating(avisinfo.getRating());
       avisRepository.save(avis);
    }

    public List<Avis> findByUserId(int id) {
        return avisRepository.findByUserId(id);
    }
}
