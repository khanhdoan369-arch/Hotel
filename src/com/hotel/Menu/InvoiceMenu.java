package com.hotel.Menu;

import com.hotel.model.Booking;
import com.hotel.model.Invoice;
import com.hotel.service.BookingService;
import com.hotel.service.InvoiceService;
import com.hotel.util.PriceUtil;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class InvoiceMenu {

    private static final InvoiceService invoiceService = new InvoiceService();
    private static final BookingService bookingService = new BookingService();

    public static void show(Scanner scanner) {

        while (true) {

            System.out.println("\n========== INVOICE MANAGEMENT ==========");
            System.out.println("1. Create Invoice");
            System.out.println("2. View Invoices");
            System.out.println("3. Find Invoice");
            System.out.println("4. Delete Invoice");
            System.out.println("0. Back");
            System.out.print("Choose: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1:
                    createInvoice(scanner);
                    break;

                case 2:
                    viewInvoices();
                    break;

                case 3:
                    findInvoice(scanner);
                    break;

                case 4:
                    deleteInvoice(scanner);
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
    // ================= Tạo hoá đơn =================
    private static void createInvoice(Scanner scanner) {

        System.out.print("Invoice ID: ");
        String invoiceId = scanner.nextLine();

        System.out.print("Booking ID: ");
        String bookingId = scanner.nextLine();

        Booking booking = bookingService.findBookingById(bookingId);

        if (booking == null) {
            System.out.println("Booking not found.");
            return;
        }

        Invoice invoice = new Invoice();

        invoice.setInvoiceId(invoiceId);
        invoice.setBooking(booking);
        invoice.setCreatedDate(LocalDateTime.now());

        invoiceService.addInvoice(invoice);

        System.out.println("Invoice created successfully.");
    }
    // ================= Xem hoá đơn =================
    private static void viewInvoices() {

        List<Invoice> invoices = invoiceService.getAllInvoices();

        if (invoices.isEmpty()) {
            System.out.println("No invoices found.");
            return;
        }

        System.out.println("\n========== INVOICE LIST ==========");

        for (Invoice invoice : invoices) {

            System.out.println("----------------------------------------");
            System.out.println("Invoice ID   : " + invoice.getInvoiceId());
            System.out.println("Booking ID   : " + invoice.getBooking().getBookingId());
            System.out.println("Customer     : " + invoice.getBooking().getCustomer().getFullName());
            System.out.println("Room Number  : " + invoice.getBooking().getRoom().getRoomNumber());
            System.out.println("Created Date : " + invoice.getCreatedDate());
            System.out.println("Total Amount : "
                    + PriceUtil.format(invoice.getTotalAmount()));
            System.out.println("----------------------------------------");
        }

    }
    // ================= Tìm hoá đơn =================
    private static void findInvoice(Scanner scanner) {

        System.out.print("Invoice ID: ");
        String invoiceId = scanner.nextLine();

        Invoice invoice = invoiceService.findInvoiceById(invoiceId);

        if (invoice == null) {

            System.out.println("Invoice not found.");

        } else {

            System.out.println("\n========== INVOICE INFORMATION ==========");
            System.out.println("Invoice ID   : " + invoice.getInvoiceId());
            System.out.println("Booking ID   : " + invoice.getBooking().getBookingId());
            System.out.println("Customer     : " + invoice.getBooking().getCustomer().getFullName());
            System.out.println("Room Number  : " + invoice.getBooking().getRoom().getRoomNumber());
            System.out.println("Created Date : " + invoice.getCreatedDate());
            System.out.println("Total Amount : "
                    + PriceUtil.format(invoice.getTotalAmount()));
            System.out.println("----------------------------------------");

        }

    }
    // ================= Xoá hoá đơn =================
    private static void deleteInvoice(Scanner scanner) {

        System.out.print("Invoice ID: ");
        String invoiceId = scanner.nextLine();

        Invoice invoice = invoiceService.findInvoiceById(invoiceId);

        if (invoice == null) {
            System.out.println("Invoice not found.");
            return;
        }

        invoiceService.deleteInvoice(invoiceId);

        System.out.println("Invoice deleted successfully.");
    }
}