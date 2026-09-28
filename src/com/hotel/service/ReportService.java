package com.hotel.service;

import com.hotel.model.Booking;
import com.hotel.model.Invoice;

import java.util.List;

public class ReportService {

    private final BookingService bookingService;
    private final InvoiceService invoiceService;

    public ReportService() {

        bookingService = new BookingService();
        invoiceService = new InvoiceService();

    }

    /**
     * Tổng doang thu
     */
    public double getTotalRevenue() {

        double total = 0;

        List<Invoice> invoices = invoiceService.getAllInvoices();

        for (Invoice invoice : invoices) {

            total += invoice.getTotalAmount();

        }

        return total;
    }

    /**
     * Số Bookings
     */
    public int getTotalBookings() {

        return bookingService.getAllBookings().size();

    }

    /**
     * Số hoá đơn
     */
    public int getTotalInvoices() {

        return invoiceService.getAllInvoices().size();

    }

    /**
     * Báo cáo doanh thu
     */
    public void revenueReport() {

        System.out.println("\n========== REVENUE REPORT ==========");
        System.out.println("Total Revenue : " + getTotalRevenue());
        System.out.println("Total Invoice : " + getTotalInvoices());

    }

    /**
     * Báo cáo Booking
     */
    public void bookingReport() {

        System.out.println("\n========== BOOKING REPORT ==========");

        List<Booking> bookings = bookingService.getAllBookings();

        if (bookings.isEmpty()) {

            System.out.println("No booking found.");
            return;

        }

        for (Booking booking : bookings) {

            System.out.println(booking);

        }

        System.out.println("-------------------------------------");
        System.out.println("Total Booking : " + bookings.size());

    }

}