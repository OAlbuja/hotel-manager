package com.hotel.microservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Room {
    @Id
    private Long roomId;
    private String roomNumber;
    private String roomType;
    private String status; // disponible, mantenimiento
    // Getters y Setters
}