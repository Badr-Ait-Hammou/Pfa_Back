package com.example.projet_pfa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String fullName;
    private String firstAdresse;
    private String secondAdresse;
    private String phoneNumber;
    private int postCode;
    private String Area;
    private String email;
    @Column(length =50000)
    private String photo;

    @OneToOne
    private User user;

}
