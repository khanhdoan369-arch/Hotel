package com.hotel.Menu;

import com.hotel.model.Booking;
import com.hotel.model.Customer;
import com.hotel.model.Room;
import com.hotel.service.BookingService;
import com.hotel.service.CustomerService;
import com.hotel.service.RoomService;
import com.hotel.util.PriceUtil;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class BookingMenu {

    private static final BookingService bookingService = new BookingService();
    private static final CustomerService customerService = new CustomerService();
    private static final RoomService roomService = new RoomService();

    public static void show(Scanner scanner) {

        while (true) {

            System.out.println("\n========== BOOKING MANAGEMENT ==========");
            System.out.println("1. Add Booking");
            System.out.println("2. View Bookings");
            System.out.println("3. Find Booking");
            System.out.println("4. Update Booking");
            System.out.println("5. Delete Booking");
            System.out.println("0. Back");
            System.out.print("Choose: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1:
                    addBooking(scanner);
                    break;

                case 2:
                    viewBookings();
                    break;

                case 3:
                    findBooking(scanner);
                    break;

                case 4:
                    updateBooking(scanner);
                    break;

                case 5:
                    deleteBooking(scanner);
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // ================= Thêm đơn đặt phòng =================

    private static void addBooking(Scanner scanner) {

        try {

            System.out.print("Booking ID: ");
            String bookingId = scanner.nextLine();

            System.out.print("Customer ID: ");
            String customerId = scanner.nextLine();

            Customer customer = customerService.findCustomerById(customerId);

            if (customer == null) {
                System.out.println("Customer not found.");
                return;
            }

            System.out.print("Room ID: ");
            String roomId = scanner.nextLine();

            Room room = roomService.findRoomById(roomId);

            if (room == null) {
                System.out.println("Room not found.");
                return;
            }

            System.out.print("Check In (yyyy-MM-dd): ");
            LocalDate checkIn =
                    LocalDate.parse(scanner.nextLine());

            System.out.print("Check Out (yyyy-MM-dd): ");
            LocalDate checkOut =
                    LocalDate.parse(scanner.nextLine());

            System.out.print("Status: ");
            String status = scanner.nextLine();

            System.out.print("Total Price: ");
            double totalPrice =
                    Double.parseDouble(scanner.nextLine());

            Booking booking = new Booking(
                    bookingId,
                    customer,
                    room,
                    checkIn,
                    checkOut,
                    status,
                    totalPrice
            );

            bookingService.addBooking(booking);

            System.out.println("Booking added successfully.");

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }

    }

    // ================= Xem đơn đặt phòng =================

    private static void viewBookings() {

        List<Booking> bookings = bookingService.getAllBookings();

        if (bookings.isEmpty()) {

            System.out.println("No bookings found.");
            return;

        }

        System.out.println("\n========== BOOKING LIST ==========");

        for (Booking booking : bookings) {

            System.out.println("----------------------------------------");
            System.out.println("Booking ID   : " + booking.getBookingId());
            System.out.println("Customer     : " + booking.getCustomer().getFullName());
            System.out.println("Room ID      : " + booking.getRoom().getId());
            System.out.println("Room Number  : " + booking.getRoom().getRoomNumber());
            System.out.println("Check In     : " + booking.getCheckInDate());
            System.out.println("Check Out    : " + booking.getCheckOutDate());
            System.out.println("Status       : " + booking.getStatus());
            System.out.println("Total Price  : " + PriceUtil.format(booking.getTotalPrice()));
            System.out.println("----------------------------------------");

        }

    }

    // ================= Tìm đơn đặt phòng =================

    private static void findBooking(Scanner scanner) {

        System.out.print("Booking ID: ");
        String bookingId = scanner.nextLine();

        Booking booking = bookingService.findBookingById(bookingId);

        if (booking == null) {

            System.out.println("Booking not found.");

        } else {

            System.out.println("\n========== BOOKING INFORMATION ==========");
            System.out.println("Booking ID   : " + booking.getBookingId());
            System.out.println("Customer     : " + booking.getCustomer().getFullName());
            System.out.println("Room ID      : " + booking.getRoom().getId());
            System.out.println("Room Number  : " + booking.getRoom().getRoomNumber());
            System.out.println("Check In     : " + booking.getCheckInDate());
            System.out.println("Check Out    : " + booking.getCheckOutDate());
            System.out.println("Status       : " + booking.getStatus());
            System.out.println("Total Price  : " + PriceUtil.format(booking.getTotalPrice()));
            System.out.println("----------------------------------------");

        }

    }

    // ================= Chỉnh sửa đơn đặt phòng =================

    private static void updateBooking(Scanner scanner) {

        System.out.print("Booking ID: ");
        String bookingId = scanner.nextLine();

        Booking booking = bookingService.findBookingById(bookingId);

        if (booking == null) {

            System.out.println("Booking not found.");
            return;

        }

        try {

            System.out.println("\n========== CURRENT BOOKING ==========");
            System.out.println("Customer     : " + booking.getCustomer().getFullName());
            System.out.println("Room Number  : " + booking.getRoom().getRoomNumber());
            System.out.println("Current Price: " + PriceUtil.format(booking.getTotalPrice()));

            System.out.print("New Status: ");
            booking.setStatus(scanner.nextLine());

            System.out.print("New Total Price: ");
            booking.setTotalPrice(Double.parseDouble(scanner.nextLine()));

            bookingService.updateBooking(booking);

            System.out.println("Booking updated successfully.");

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }

    }

    // ================= Xoá đơn đặt phòng =================

    private static void deleteBooking(Scanner scanner) {

        System.out.print("Booking ID: ");
        String bookingId = scanner.nextLine();

        Booking booking =
                bookingService.findBookingById(bookingId);

        if (booking == null) {

            System.out.println("Booking not found.");
            return;

        }

        bookingService.deleteBooking(bookingId);

        System.out.println("Booking deleted successfully.");

    }

}