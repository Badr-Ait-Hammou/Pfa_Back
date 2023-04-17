package com.example.projet_pfa.service;

import com.example.projet_pfa.dao.Dao;
import com.example.projet_pfa.entity.Avis;
import com.example.projet_pfa.repository.AvisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvisService implements Dao<Avis> {

    @Autowired
    private AvisRepository avisRepository;

    @Override
    public Avis save(Avis o) {
        return null;
    }

    @Override
    public List<Avis> findAll() {
        return null;
    }

    @Override
    public Avis findById(int id) {
        return null;
    }

    @Override
    public void delete(Avis o) {

    }
}
