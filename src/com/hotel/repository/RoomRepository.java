package com.hotel.repository;

import com.hotel.model.Room;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoomRepository implements GenericRepository<Room> {

    private static final Map<String, Room> roomMap = new HashMap<>();

    @Override
    public void add(Room room) {
        roomMap.put(room.getId(), room);
    }

    @Override
    public void update(Room room) {
        roomMap.put(room.getId(), room);
    }

    @Override
    public void delete(String id) {
        roomMap.remove(id);
    }

    @Override
    public Room findById(String id) {
        return roomMap.get(id);
    }

    @Override
    public List<Room> findAll() {
        return new ArrayList<>(roomMap.values());
    }

    public boolean exists(String id) {
        return roomMap.containsKey(id);
    }
}
