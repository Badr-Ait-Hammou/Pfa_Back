package com.example.projet_pfa.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalTime;
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
   // @Temporal(TemporalType.TIMESTAMP)
   @JsonFormat(pattern="HH:mm")
    private LocalTime dateFermeture;
   // @Temporal(TemporalType.TIMESTAMP)
   @JsonFormat(pattern="HH:mm")
    private LocalTime  dateOuverture;
    private String latitude;
    private String longitude;
    private String adresse;
   // private double rank;
   @Column(length =500000)
   private String photo;

    @ManyToOne
    private Serie serie;

   /* @ManyToOne
    private User user;
*/
    @ManyToOne
    @JoinColumn(name = "zone_id")
    private Zone zone;

    @ManyToOne
    private Specialite specialite;

    @ManyToOne
    @JsonIgnoreProperties({"restaurantList"})
    private User user;

//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id", unique = true)
//    private User user;

//    @OneToMany(mappedBy = "restaurant", fetch = FetchType.EAGER)
    @OneToMany(mappedBy = "restaurant", fetch = FetchType.LAZY)
    //@JsonIgnore
    private List<Produit> produitList;

    @OneToMany(mappedBy = "restaurant",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Reservation> reservationList;







}
