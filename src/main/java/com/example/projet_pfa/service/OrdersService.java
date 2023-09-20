package com.example.projet_pfa.service;

import com.example.projet_pfa.dao.Dao;
import com.example.projet_pfa.entity.*;

import com.example.projet_pfa.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrdersService implements Dao<Orders> {


    public List<Orders> findOrdersByUserIdAndUserRole(int userId) {
        return ordersRepository.findOrdersByUserIdAndUserRole(userId);
    }

    @Autowired
    private OrdersRepository ordersRepository;


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



    public void deleteById(int id) {
        ordersRepository.deleteById(id);
    }


    public void updateSatus(Integer id, Orders ordersinfo) {
        Orders orders=ordersRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("orders not found with id " + id));
        orders.setStatus(ordersinfo.getStatus());
        ordersRepository.save(orders);
    }


    public Long countDeliveredOrders() {
        return ordersRepository.countDeliveredOrders();
    }

    public Long countPendingOrders() {
        return ordersRepository.countPendingOrders();
    }

    public BigDecimal sumTotalPriceOfDeliveredOrders() {
        return ordersRepository.sumTotalPriceOfDeliveredOrders();
    }

    public BigDecimal sumTotalPriceOfPendingOrders() {
        return ordersRepository.sumTotalPriceOfPendingOrders();
    }

}
