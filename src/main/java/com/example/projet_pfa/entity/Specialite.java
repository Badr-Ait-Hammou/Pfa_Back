package com.example.projet_pfa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Specialite {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String nom;
    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String photo;

   @OneToMany
   @JsonIgnore
   private List<Restaurant> restaurantList;


}
