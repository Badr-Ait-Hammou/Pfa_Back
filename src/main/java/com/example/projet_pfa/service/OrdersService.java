package com.example.projet_pfa.service;

import com.example.projet_pfa.dao.Dao;
import com.example.projet_pfa.entity.*;

import com.example.projet_pfa.repository.OrdersItemRepository;
import com.example.projet_pfa.repository.OrdersRepository;
import com.example.projet_pfa.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrdersService implements Dao<Orders> {

    public List<Orders> findAllOrders() {
        return ordersRepository.findAllOrders();
    }


    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private OrdersItemService ordersItemService;



    public List<Orders> findByUserId(int id) {
        return ordersRepository.findByUserId(id);
    }

    @Override
    public Orders save(Orders orders) throws Exception  {
        return ordersRepository.save(orders);
    }


    @Override
    public List<Orders> findAll() {
        return ordersRepository.findAll();
    }

    @Override
    public Orders findById(int id) {
        return ordersRepository.findById(id);
    }

    @Override
    public void delete(Orders o) {

    }

    public void saveOrderwithOrderItems(Orders orders){
        orders.setDateCreated(new Date());
            ordersRepository.save(orders);
            ordersItemService.saveOrderItems(orders,orders.getOrderItem());
    }


}
