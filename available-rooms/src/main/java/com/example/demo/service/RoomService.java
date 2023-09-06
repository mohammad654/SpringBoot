package com.example.demo.service;

import com.example.demo.model.Room;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface RoomService {

    public Room save(Room room);

    public Iterable<Room> saveAll(Iterable<Room> rooms);

    public Optional<Room> findById(Long id);

    public Iterable<Room> findAll();

    public void deleteById(Long id);

    public List<Room> getAvailableRooms(Room room, LocalDate startDate, LocalDate endDate);
}
