package com.example.projet_pfa.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class OrderRequestDTO {
    private int quantity;
    private double totalAmount;
    private List<OrderItemRequestDTO> orderItems;
}
