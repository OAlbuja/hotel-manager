package com.hotel.api.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.hotel.api.model.Reservation;
import com.hotel.api.repository.ReservationRepository;
// Importa SoapClient

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private SoapClient soapClient;

    @PostMapping
    public Reservation createReservation(@RequestBody Reservation reservation) {
        // Verificar disponibilidad usando soapClient
        // Guardar reserva si hay disponibilidad
    }

    @GetMapping("/{id}")
    public Reservation getReservation(@PathVariable Long id) {
        return reservationRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void cancelReservation(@PathVariable Long id) {
        reservationRepository.deleteById(id);
    }
}