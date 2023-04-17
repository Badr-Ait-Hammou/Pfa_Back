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
    public Restaurant save(@RequestBody Restaurant o){
         return restaurantService.save(o);
     }
     @GetMapping("/")
    public List<Restaurant> findAll(){
         return restaurantService.findAll();
     }
     @GetMapping("/{id}")
    public Restaurant findById(@PathVariable String id){
         return restaurantService.findById(Integer.parseInt(id));
     }
     @DeleteMapping("/delete")
    public void delete(@RequestBody Restaurant o){
         restaurantService.delete(o);
     }
}
