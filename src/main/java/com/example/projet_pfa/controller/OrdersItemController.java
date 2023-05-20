package com.example.projet_pfa.controller;

import com.example.projet_pfa.entity.OrdersItem;
import com.example.projet_pfa.service.OrdersItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/controller/ordersitem")
@CrossOrigin
public class OrdersItemController {

    @Autowired
    private OrdersItemService ordersItemService;

    @PostMapping("/")
    public OrdersItem save(@RequestBody OrdersItem orderItem) {
        return ordersItemService.save(orderItem);
    }

    @GetMapping("/")
    public List<OrdersItem> findAll() {
        return ordersItemService.findAll();
    }

    @GetMapping("/{id}")
    public OrdersItem findById(@PathVariable int id) {
        return ordersItemService.findById(id);
    }


    public void delete(OrdersItem o) {
        ordersItemService.delete(o);
    }


}
