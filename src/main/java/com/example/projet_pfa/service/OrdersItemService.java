package com.example.projet_pfa.service;

import com.example.projet_pfa.dao.Dao;
import com.example.projet_pfa.entity.Orders;
import com.example.projet_pfa.entity.OrdersItem;
import com.example.projet_pfa.repository.OrdersItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdersItemService implements Dao<OrdersItem> {

    public List<OrdersItem> findByOrders(Orders orders) {
        return ordersItemRepository.findByOrders(orders);
    }

    @Autowired
    private OrdersItemRepository ordersItemRepository;

    @Override
    public OrdersItem save(OrdersItem ordersItem) {

            return ordersItemRepository.save(ordersItem);
        }


    @Override
    public List<OrdersItem> findAll() {
        return ordersItemRepository.findAll();
    }

    @Override
    public OrdersItem findById(int id) {
        return ordersItemRepository.findById(id).orElseThrow();
    }

    @Override
    public void delete(OrdersItem o) {

    }
    public int saveOrderItems(Orders orders, List<OrdersItem> ordersItems){
        if (ordersItems != null && !ordersItems.isEmpty()) {
            for (OrdersItem ordersItem : ordersItems) {
                ordersItem.setOrders(orders);
                ordersItemRepository.save(ordersItem);
            }
        }
        return 1;
    }
}
