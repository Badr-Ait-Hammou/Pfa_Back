package com.example.projet_pfa.controller;

import com.example.projet_pfa.entity.*;
import com.example.projet_pfa.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/controller/orders")
@CrossOrigin
public class OrdersController {


    @GetMapping("/userorder/{id}")
    public List<Orders> findByUserId(@PathVariable int id) {
        return ordersService.findByUserId(id);
    }

    @Autowired
    private OrdersService ordersService;
    @PostMapping("/save")
    public void saveOrderwithOrderItems(@RequestBody Orders orders) {
        ordersService.saveOrderwithOrderItems(orders);
    }

    @GetMapping("/all")
    public List<Orders> findAllOrders() {
        return ordersService.findAllOrders();
    }

    @PostMapping("/")
    public Orders save(@RequestBody Orders orders)  throws Exception{
        return ordersService.save(orders);
    }

    @GetMapping("/")
    public List<Orders> findAll() {
        return ordersService.findAll();
    }

    @GetMapping("/{id}")
    public Orders findById(@PathVariable int id) {
        return ordersService.findById(id);
    }

    public void delete(Orders o) {
        ordersService.delete(o);
    }


}
