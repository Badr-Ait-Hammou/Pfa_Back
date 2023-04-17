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
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String reference;
    @Temporal(TemporalType.DATE)
    private Date dateCommande;
    private String telephone;
    private Double prixCommande;
    private String etatCommande;
    private String adresseLivraison;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
    @JoinTable(
            name = "commande_produit",
            joinColumns = @JoinColumn(name = "commande_id"),
            inverseJoinColumns = @JoinColumn(name = "produit_id"))
    private List<Produit> produitList;

   // @OneToOne(mappedBy = "commande")
    @OneToOne
    private Avis avis;

}
