package com.example.projet_pfa.service;

import com.example.projet_pfa.dao.Dao;
import com.example.projet_pfa.entity.Orders;
import com.example.projet_pfa.entity.OrdersItem;
import com.example.projet_pfa.entity.Produit;
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

    @Autowired
    private OrdersItemRepository ordersItemRepository;

    @Autowired
    private ProduitRepository produitRepository;



    @Override
    public Orders save(Orders orders) throws Exception  {
        return ordersRepository.save(orders);
    }

  /*  public Orders saveOrder(Orders orders) {
        Orders savedOrder = ordersRepository.save(orders); // Save the order to get the generated order ID
        for (OrdersItem orderItem : orders.getOrderItem()) {
            orderItem.setOrders(ordersRepository.findById(savedOrder.getId()));
            orderItem.setProduit(ordersRepository.findById(savedOrder.getProduit().getId()));
            orderItem.setProduit(savedOrder.getProduit());
           // orderItem.setProduit(sa);
            ordersItemRepository.save(orderItem);
        }
        for (OrdersItem orderItem : orders.getOrderItem()) {
            orderItem.setOrders(savedOrder);
            orderItem.setProduit(savedOrder.getProduit());
            ordersItemRepository.save(orderItem);
        }

        return savedOrder;
    }
*/

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

   /* public void saveOrderwithOrderItems(Orders orders, List<OrdersItem> ordersItems) {
        orders.setDateCreated(new Date());

        for (OrdersItem item : ordersItems) {
            Produit product = produitRepository.findById(item.getProduit().getId());
            item.setOrders(orders);
            item.setProduit(product);
        }
        orders.setOrderItem(ordersItems);

        ordersRepository.save(orders);
    }*/
}
