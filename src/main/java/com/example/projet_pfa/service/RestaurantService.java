package com.example.projet_pfa.service;

import com.example.projet_pfa.dao.Dao;
import com.example.projet_pfa.entity.Restaurant;
import com.example.projet_pfa.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService implements Dao<Restaurant> {


    public List<Restaurant> findPharmaciyByVilleAndZone(String ville, String zone) {
        return restaurantRepository.findPharmaciyByVilleAndZone(ville, zone);
    }

    @Autowired
    private RestaurantRepository restaurantRepository;
    @Override
    public Restaurant save(Restaurant o) {
        return this.restaurantRepository.save(o);
    }

    @Override
    public List<Restaurant> findAll() {
        return this.restaurantRepository.findAll();
    }

    @Override
    public Restaurant findById(int id) {
        return this.restaurantRepository.findById(id);
    }

    @Override
    public void delete(Restaurant o) {
       this.restaurantRepository.delete(o);
    }
}
