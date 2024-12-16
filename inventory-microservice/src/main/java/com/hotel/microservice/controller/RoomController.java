package com.hotel.microservice.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.hotel.microservice.model.Room;
import com.hotel.microservice.repository.RoomRepository;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    private RoomRepository roomRepository;

    @PostMapping
    public Room createRoom(@RequestBody Room room) {
        return roomRepository.save(room);
    }

    @PatchMapping("/{id}")
    public Room updateRoomStatus(@PathVariable Long id, @RequestBody Map<String, String> updates) {
        Room room = roomRepository.findById(id).orElse(null);
        if (room != null && updates.containsKey("status")) {
            room.setStatus(updates.get("status"));
            roomRepository.save(room);
        }
        return room;
    }
}