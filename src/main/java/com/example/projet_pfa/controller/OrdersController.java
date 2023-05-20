package com.example.projet_pfa.controller;

import com.example.projet_pfa.entity.*;
import com.example.projet_pfa.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/controller/orders")
@CrossOrigin
public class OrdersController {


    @PostMapping("/save")
    public void saveOrderwithOrderItems(@RequestBody Orders orders) {
        ordersService.saveOrderwithOrderItems(orders);
    }
  /*  @PostMapping("/save")
    public Orders saveOrder(@RequestBody Orders orders) {
        return ordersService.saveOrder(orders);
    }

   */
/*
    @PostMapping("/save")
    public ResponseEntity<String> createOrder(@RequestBody OrderRequestDTO orderRequest) {
        Orders order = new Orders();
        order.setDateCreated(new Date());
        List<OrdersItem> orderItems = new ArrayList<>();
        for (OrderItemRequestDTO itemRequest : orderRequest.getOrderItems()) {
            OrdersItem orderItem = new OrdersItem();
            orderItem.setProduit(new Produit());
            orderItems.add(orderItem);
        }
        ordersService.saveOrderWithItems(order, orderItems);
        return ResponseEntity.ok("Order created successfully");
    }
    */

    @GetMapping("/all")
    public List<Orders> findAllOrders() {
        return ordersService.findAllOrders();
    }

    @Autowired
    private OrdersService ordersService;

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
