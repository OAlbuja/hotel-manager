package com.hotel.api.controller;

import com.hotel.api.client.SoapClient;
import com.hotel.api.model.Reservation;
import com.hotel.api.repository.ReservationRepository;
import com.hotel.availability.CheckAvailabilityResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private SoapClient soapClient;

    @PostMapping
    public Reservation createReservation(@RequestBody Reservation reservation) {
        // Llamar al servicio SOAP para verificar disponibilidad
        CheckAvailabilityResponse response = soapClient.checkAvailability(
                reservation.getStartDate().toString(),
                reservation.getEndDate().toString(),
                reservation.getRoomType());

        if (response.getAvailableRooms() != null && !response.getAvailableRooms().isEmpty()) {
            reservation.setStatus("CONFIRMED");
            return reservationRepository.save(reservation);
        } else {
            throw new RuntimeException("No hay habitaciones disponibles.");
        }
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
