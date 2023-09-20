package com.example.projet_pfa.repository;

import com.example.projet_pfa.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders,Integer> {
 Orders findById(int id);


 @Query("SELECT COUNT(o) FROM Orders o WHERE o.status = 'Delivered'")
 Long countDeliveredOrders();

 @Query("SELECT COUNT(o) FROM Orders o WHERE o.status = 'Shipped'")
 Long countPendingOrders();

 @Query("SELECT SUM(o.totalPrice) FROM Orders o WHERE o.status = 'Delivered'")
 BigDecimal sumTotalPriceOfDeliveredOrders();

 @Query("SELECT SUM(o.totalPrice) FROM Orders o WHERE o.status = 'Shipped'")
 BigDecimal sumTotalPriceOfPendingOrders();


 List<Orders> findByUserId(int id);
}
