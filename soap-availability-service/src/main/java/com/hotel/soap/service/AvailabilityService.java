package com.hotel.soap.service;

import com.hotel.soap.model.Availability;
import com.hotel.soap.repository.AvailabilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvailabilityService {

    @Autowired
    private AvailabilityRepository availabilityRepository;

    public List<Availability> getAllAvailableRooms() {
        return availabilityRepository.findAll();
    }
}