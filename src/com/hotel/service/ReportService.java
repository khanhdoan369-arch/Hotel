package com.hotel.service;

import com.hotel.model.Booking;

import java.util.List;

public class ReportService {

    public double calculateRevenue(List<Booking> bookings) {

        double total = 0;

        for (Booking booking : bookings) {
            total += booking.getTotalPrice();
        }

        return total;
    }

}
