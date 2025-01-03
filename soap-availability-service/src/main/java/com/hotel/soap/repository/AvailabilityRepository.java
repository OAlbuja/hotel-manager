package com.hotel.soap.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.soap.model.Availability;

import java.time.LocalDate;
import java.util.List;

public interface AvailabilityRepository extends JpaRepository<Availability, String> {
    List<Availability> findByRoomTypeAndAvailableDateBetweenAndStatus(
        String roomType, LocalDate startDate, LocalDate endDate, String status);
        List<Availability> findByAvailableDateBetweenAndStatus(LocalDate startDate, LocalDate endDate, String status);
}