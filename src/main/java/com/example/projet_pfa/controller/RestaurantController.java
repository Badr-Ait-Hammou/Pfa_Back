package com.example.projet_pfa.controller;

import com.example.projet_pfa.entity.Restaurant;
import com.example.projet_pfa.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {


    @Autowired
     private RestaurantService restaurantService;

     @PostMapping("/save")
    public Restaurant save(@RequestBody Restaurant restaurant){
         return restaurantService.save(restaurant);
     }
     @GetMapping("/")
    public List<Restaurant> findAll(){
         return restaurantService.findAll();
     }

     @GetMapping("/{ville}/{zone}")
    public List<Restaurant> findPharmaciyByVilleAndZone(@PathVariable String ville,@PathVariable String zone) {
        return restaurantService.findPharmaciyByVilleAndZone(ville, zone);
    }

    @DeleteMapping("/")
    public void deleteCommande(@PathVariable Integer id) {
        restaurantService.deleteCommande(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id,@RequestBody Restaurant restaurantinfo) {
        restaurantService.update(id, restaurantinfo);
    }

}
