package com.hotel.service;

import com.hotel.model.Booking;
import com.hotel.repository.BookingRepository;

import java.util.List;

public class BookingService {

    private final BookingRepository repository;

    public BookingService() {
        repository = new BookingRepository();
    }

    /**
     * Thêm Booking.
     */
    public void addBooking(Booking booking) {
        repository.add(booking);
    }

    /**
     * Cập nhật booking.
     */
    public void updateBooking(Booking booking) {
        repository.update(booking);
    }

    /**
     * Xoá booking.
     */
    public void deleteBooking(String bookingId) {
        repository.delete(bookingId);
    }

    /**
     * Tìm Booking bằng ID.
     */
    public Booking findBookingById(String bookingId) {
        return repository.findById(bookingId);
    }

    /**
     * In toàn bộ bookings.
     */
    public List<Booking> getAllBookings() {
        return repository.findAll();
    }

}