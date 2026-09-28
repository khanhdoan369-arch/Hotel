package com.hotel.repository;

import com.hotel.model.Booking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookingRepository implements GenericRepository<Booking> {

    private static final Map<String, Booking> bookingMap = new HashMap<>();

    @Override
    public void add(Booking booking) {
        bookingMap.put(booking.getBookingId(), booking);
    }

    @Override
    public void update(Booking booking) {
        bookingMap.put(booking.getBookingId(), booking);
    }

    @Override
    public void delete(String bookingId) {
        bookingMap.remove(bookingId);
    }

    @Override
    public Booking findById(String bookingId) {
        return bookingMap.get(bookingId);
    }

    @Override
    public List<Booking> findAll() {
        return new ArrayList<>(bookingMap.values());
    }
}