package com.example.projet_pfa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    //private String orderStatus;
    //private String paymentStatus;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    //private double orderAmt;
   // private String billingAdresse;
    private double totalPrice;
    private int productQuantity;

    @OneToMany(mappedBy = "orders", fetch = FetchType.EAGER)
    private List<OrdersItem> orderItem;
    @ManyToOne
    private User user;

 /*   @ManyToOne
    private Produit produit;
*/
}
