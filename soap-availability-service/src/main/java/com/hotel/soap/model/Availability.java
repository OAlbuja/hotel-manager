package com.hotel.soap.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Availability {
    @Id
    private String roomId;
    private String roomType;
    private LocalDate availableDate;
    private String status;
    // Getters y Setters
}