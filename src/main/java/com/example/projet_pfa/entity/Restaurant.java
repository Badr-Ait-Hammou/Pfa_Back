package com.example.projet_pfa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    @Temporal(TemporalType.DATE)
    private Date heurFermeture;
    private Date heurOuverture;
    private Date jourOuverture;
    private int lattitude;
    private int langitude;
    private String adresse;
    private double rank;
    private byte photo;
    @ManyToOne
    @JoinColumn(name = "zone_id")
    private Zone zone;






}
