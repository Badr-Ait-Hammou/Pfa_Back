package com.example.projet_pfa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class Serie {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String nom;
    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String photo;

    @OneToMany(mappedBy = "serie", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Restaurant> restaurantList;



}

