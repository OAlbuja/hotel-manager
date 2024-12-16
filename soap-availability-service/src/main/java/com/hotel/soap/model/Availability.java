package com.hotel.soap.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "availability")
@Data
public class Availability {
    @Id
    private String roomId;
    private String roomType;
    private LocalDate availableDate;
    private String status;
}