package com.example.projet_pfa.service;

import com.example.projet_pfa.dao.Dao;
import com.example.projet_pfa.entity.Commande;
import com.example.projet_pfa.entity.Restaurant;
import com.example.projet_pfa.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
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
    public Restaurant save(Restaurant restaurant) {
        return this.restaurantRepository.save(restaurant);
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

    }
    public void deleteCommande(Integer id){
        Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("restaurant not found with id " + id));
        restaurantRepository.delete(restaurant);
    }
    public void update(Integer id, Restaurant restaurantinfo) {
        Restaurant restaurant=restaurantRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("restaurant not found with id " + id));
        restaurant.setNom(restaurantinfo.getNom());
        restaurant.setAdresse(restaurantinfo.getAdresse());
        restaurant.setHeurFermeture(restaurantinfo.getHeurFermeture());
        restaurant.setHeurOuverture(restaurantinfo.getHeurOuverture());
        restaurant.setJourOuverture(restaurantinfo.getJourOuverture());
        restaurant.setLangitude(restaurantinfo.getLangitude());
        restaurant.setLattitude(restaurantinfo.getLattitude());
        restaurant.setRank(restaurantinfo.getRank());
        restaurant.setPhoto(restaurantinfo.getPhoto());
        restaurant.setSerie(restaurantinfo.getSerie());
        restaurant.setZone(restaurantinfo.getZone());
        restaurant.setUser(restaurantinfo.getUser());
        restaurantRepository.save(restaurant);
    }
}
