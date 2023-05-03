package com.example.projet_pfa.entity;

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
    private String photo;
    @ManyToOne
    @JoinColumn(name = "zone_id")
    private Zone zone;

    @ManyToMany
    private List<Specialite> specialiteList;
    @ManyToOne
    private Serie serie;

    @ManyToOne
    private User user;







}
