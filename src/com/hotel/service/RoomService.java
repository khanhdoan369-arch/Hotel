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

    /**
     * Thêm phòng.
     */
    public void addRoom(Room room) throws DuplicateRoomException {

        if (repository.exists(room.getId())) {
            throw new DuplicateRoomException("Room ID already exists.");
        }

        repository.add(room);
    }

    /**
     * Cập nhật thông tin phòng
     */
    public void updateRoom(Room room)
            throws RoomNotFoundException {

        if (repository.findById(room.getId()) == null) {
            throw new RoomNotFoundException("Room not found.");
        }

        repository.update(room);
    }

    /**
     * Xoá phòng.
     */
    public void deleteRoom(String id)
            throws RoomNotFoundException {

        if (repository.findById(id) == null) {
            throw new RoomNotFoundException("Room not found.");
        }

        repository.delete(id);
    }

    /**
     * Tiìm phòng bằng ID.
     */
    public Room findRoomById(String id)
            throws RoomNotFoundException {

        Room room = repository.findById(id);

        if (room == null) {
            throw new RoomNotFoundException("Room not found.");
        }

        return room;
    }

    /**
     * Lấy thông tin của tất cả các phòng.
     */
    public List<Room> getAllRooms() {
        return repository.findAll();
    }

}