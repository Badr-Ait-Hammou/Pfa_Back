package com.example.projet_pfa.service;

import com.example.projet_pfa.dao.Dao;
import com.example.projet_pfa.entity.Serie;
import com.example.projet_pfa.entity.User;
import com.example.projet_pfa.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SerieService implements Dao<Serie> {

    @Autowired
    private SerieRepository serieRepository;

    @Override
    public Serie save(Serie serie) { return this.serieRepository.save(serie); }

    @Override
    public List<Serie> findAll() { return this.serieRepository.findAll(); }

    @Override
    public Serie findById(int id) { return this.serieRepository.findById(id);}

    @Override
    public void delete(Serie serie) { this.serieRepository.delete(serie);}

    public void update(Integer id, Serie serieinfo) {
        Serie serie=serieRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("serie not found with id " + id));
        serie.setNom(serieinfo.getNom());
        serieRepository.save(serie);
    }

    public void deleteSerie(Integer id){
        Serie serie = serieRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("serie not found with id " + id));
        serieRepository.delete(serie);
    }

}
