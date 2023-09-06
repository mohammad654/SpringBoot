package com.example.demo.controller;

import com.example.demo.model.Reservation;
import com.example.demo.model.Room;
import com.example.demo.service.ReservationService;
import com.example.demo.service.RoomService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RoomController {

    protected static final Logger logger = LogManager.getLogger(RoomController.class);
    @Autowired
    RoomService roomService;

    @PostMapping(value = "/room/available", consumes = "application/json", produces = "application/json")
    public ResponseEntity<List<Room>> getAvailableRooms(
            @RequestBody final Room room,
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate
            ) {

        logger.info("Inside 'saveReservation'");

        List<Room> rooms = roomService.getAvailableRooms(room, startDate, endDate);

        return ResponseEntity.ok(rooms) ;

    }
}
