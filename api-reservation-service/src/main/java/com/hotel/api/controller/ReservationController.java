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
    
    @PostMapping
    public Reservation createReservation(@RequestBody Reservation reservation) {
        // Crear request para el servicio SOAP
        CheckAvailabilityRequest soapRequest = new CheckAvailabilityRequest();
        soapRequest.setStartDate(reservation.getStartDate().toString());
        soapRequest.setEndDate(reservation.getEndDate().toString());
        soapRequest.setRoomType("Standard"); // Puedes parametrizar esto

        // Llamar al servicio SOAP para verificar disponibilidad
        CheckAvailabilityResponse soapResponse = soapClient.checkAvailability(soapRequest);

        if (soapResponse.getAvailableRooms() != null && !soapResponse.getAvailableRooms().isEmpty()) {
            reservation.setStatus("CONFIRMED");
            return reservationRepository.save(reservation);
        } else {
            throw new RuntimeException("No hay habitaciones disponibles para las fechas seleccionadas.");
        }
    }

}