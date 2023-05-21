package com.example.projet_pfa.repository;

import com.example.projet_pfa.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation,Integer> {
    List<Reservation> findByReservationDate(Date reservatioDate);

    List<Reservation> findByType(String type);

    Reservation findById(int id);

    List<Reservation> findByUserId(int id);
}
