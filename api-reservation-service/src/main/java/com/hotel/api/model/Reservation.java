package com.hotel.api.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Reservation {
    @Id
    private Long reservationId;
    private String roomNumber;
    private String customerName;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;
    // Getters y Setters
}