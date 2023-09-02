package com.example.projet_pfa.repository;

import com.example.projet_pfa.entity.CartItem;
import com.example.projet_pfa.entity.Orders;
import com.example.projet_pfa.entity.OrdersItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrdersItemRepository extends JpaRepository<OrdersItem,Integer> {

    List<OrdersItem> findByOrders(Orders orders);


}
