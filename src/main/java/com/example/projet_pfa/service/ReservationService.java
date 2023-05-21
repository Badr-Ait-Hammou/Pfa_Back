package com.example.projet_pfa.service;

import com.example.projet_pfa.dao.Dao;
import com.example.projet_pfa.entity.Reservation;
import com.example.projet_pfa.repository.ReservationRepository;
import com.example.projet_pfa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class ReservationService implements Dao<Reservation> {

    public List<Reservation> findByUserId(int id) {
        return reservationRepository.findByUserId(id);
    }

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public Reservation save(Reservation reservation)  {
        reservation.setDateCreated(new Date());

        if(reservation.getReservationDate().after(reservation.getDateCreated())){
            return reservationRepository.save(reservation);
        }else
            return null;

    }

    @Override
    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation findById(int id) {
        return reservationRepository.findById(id);
    }

    @Override
    public void delete(Reservation o) {

    }

    public void deleteReservation(int id) {
        Reservation reservation= reservationRepository.findById(id);
        reservationRepository.delete(reservation);

    }
}
