package com.example.projet_pfa.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
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

    private Date dateCreated;
    private double totalPrice;
    private int productQuantity;
    private String status;

  

    @OneToMany(mappedBy = "orders",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Avis> avisList;
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    private Produit produit;
    @PrePersist
    public void prePersist() {
        dateCreated = new Date();
    }
}
