package com.example.projet_pfa.service;

import com.example.projet_pfa.dao.Dao;
import com.example.projet_pfa.entity.Orders;
import com.example.projet_pfa.entity.Reservation;
import com.example.projet_pfa.repository.ReservationRepository;
import com.example.projet_pfa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
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
        return reservationRepository.save(reservation);
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

    public void updateSatus(Integer id, Reservation reservationInfo) {
        Reservation reservation=reservationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("orders not found with id " + id));
        reservation.setStatus(reservationInfo.getStatus());
        reservationRepository.save(reservation);
    }
}
