package com.example.projet_pfa.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String status;
    private String type;
    @Temporal(TemporalType.TIMESTAMP)
    private Date reservationDate;
    private Date dateCreated;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties({ "serie", "zone","specialite","produitList","reservationList"})
    private Restaurant restaurant;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties({ "photo"})
    private User user;

    @PrePersist
    public void prePersist() {
        dateCreated = new Date();
    }
}
