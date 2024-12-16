package com.hotel.api.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    @Id
    private Long reservationId;
    private String roomNumber;
    private String customerName;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;
}
