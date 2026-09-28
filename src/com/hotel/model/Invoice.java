package com.hotel.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents an invoice.
 */
public class Invoice {

    private String invoiceId;
    private Booking booking;
    private List<Service> services;
    private double totalAmount;
    private LocalDateTime createdDate;

    public Invoice() {
        services = new ArrayList<>();
    }

    public Invoice(String invoiceId,
                   Booking booking,
                   List<Service> services,
                   double totalAmount,
                   LocalDateTime createdDate) {

        this.invoiceId = invoiceId;
        this.booking = booking;
        this.services = services;
        this.totalAmount = totalAmount;
        this.createdDate = createdDate;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * Add an additional service.
     */
    public void addService(Service service) {
        services.add(service);
    }

    /**
     * Calculate total invoice.
     */
    public void calculateTotalAmount() {

        totalAmount = booking.getTotalPrice();

        for (Service service : services) {
            totalAmount += service.getPrice();
        }
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceId='" + invoiceId + '\'' +
                ", booking=" + booking +
                ", services=" + services +
                ", totalAmount=" + totalAmount +
                ", createdDate=" + createdDate +
                '}';
    }
}