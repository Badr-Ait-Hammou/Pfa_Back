package com.example.projet_pfa.repository;

import com.example.projet_pfa.entity.Orders;
import com.example.projet_pfa.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders,Integer> {
 Orders findById(int id);

 @Query("SELECT o FROM Orders o JOIN User u ON o.user.id = u.id LEFT JOIN OrdersItem oi ON o.id=oi.orders.id LEFT JOIN Produit p ON oi.produit.id =p.id")
 List<Orders> findAllOrders();
}
