package com.example.projet_pfa.controller;

import com.example.projet_pfa.entity.*;
import com.example.projet_pfa.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/controller/orders")
@CrossOrigin
public class OrdersController {


    @GetMapping("/userrole/{userId}")
    public List<Orders> findOrdersByUserIdAndUserRole(@PathVariable int userId) {
        return ordersService.findOrdersByUserIdAndUserRole(userId);
    }

    @Autowired
    private OrdersService ordersService;

    @GetMapping("/userorder/{id}")
    public List<Orders> findByUserId(@PathVariable int id) {
        return ordersService.findByUserId(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        ordersService.deleteById(id);
    }

    @PutMapping("/status/{id}")
    public void updateSatus(@PathVariable Integer id,@RequestBody Orders ordersinfo) {
        ordersService.updateSatus(id, ordersinfo);
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


    @GetMapping("/shippedcount")
    public Long countPendingOrders() {
        return ordersService.countPendingOrders();
    }
    @GetMapping("/deliveredcount")
    public Long countDeliveredOrders() {
        return ordersService.countDeliveredOrders();
    }

    @GetMapping("/deliveredtot")
    public BigDecimal sumTotalPriceOfDeliveredOrders() {
        return ordersService.sumTotalPriceOfDeliveredOrders();
    }

    @GetMapping("/shippedtot")
    public BigDecimal sumTotalPriceOfPendingOrders() {
        return ordersService.sumTotalPriceOfPendingOrders();
    }

}
