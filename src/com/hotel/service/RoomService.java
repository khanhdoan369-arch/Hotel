package com.hotel.service;

import com.hotel.exception.DuplicateRoomException;
import com.hotel.exception.RoomNotFoundException;
import com.hotel.model.Room;
import com.hotel.repository.RoomRepository;

import java.util.List;

public class RoomService {

    private final RoomRepository repository;

    public RoomService() {
        repository = new RoomRepository();
    }

    public void addRoom(Room room) throws DuplicateRoomException {

        if (repository.exists(room.getId())) {
            throw new DuplicateRoomException("Room ID already exists.");
        }

        repository.add(room);
    }

    public List<Room> getAllRooms() {
        return repository.getAll();
    }

    public Room findRoomById(String id)
            throws RoomNotFoundException {

        Room room = repository.findById(id);

        if (room == null) {
            throw new RoomNotFoundException("Room not found.");
        }

        return room;
    }

    public void deleteRoom(String id)
            throws RoomNotFoundException {

        if (!repository.delete(id)) {
            throw new RoomNotFoundException("Room not found.");
        }

    }

}
