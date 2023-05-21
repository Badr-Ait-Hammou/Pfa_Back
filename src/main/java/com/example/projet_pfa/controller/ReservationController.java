package com.example.projet_pfa.controller;

import com.example.projet_pfa.entity.Reservation;
import com.example.projet_pfa.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/controller/reservations")
@CrossOrigin
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/user/{id}")
    public List<Reservation> findByUserId(@PathVariable int id) {
        return reservationService.findByUserId(id);
    }

    @DeleteMapping("/{id}")
    public void deleteReservation(@PathVariable int id) {
        reservationService.deleteReservation(id);
    }



    @PostMapping("/")
    public Reservation save(@RequestBody Reservation reservation) {

        return reservationService.save(reservation);
    }

    @GetMapping("/")
    public List<Reservation> findAll() {
        return reservationService.findAll();
    }

    @GetMapping("/{id}")
    public Reservation findById(@PathVariable int id) {
        return reservationService.findById(id);
    }

    public void delete(Reservation o) {
        reservationService.delete(o);
    }


}
