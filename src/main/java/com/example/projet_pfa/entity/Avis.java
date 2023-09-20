package com.example.projet_pfa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Avis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String note;
    private int rating;
    private Date commentDate;
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties({ "avisList", "ordersList","reservationList","cartList"})
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties({ "avisList", "restaurant","cartList","photo"})
    private Produit produit;
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties({ "avisList", "user","produit"})
    private Orders orders;

    @PrePersist
    public void prePersist() {
        commentDate = new Date();
    }



}
