package com.hotel;

import com.hotel.Menu.BookingMenu;
import com.hotel.Menu.CustomerMenu;
import com.hotel.Menu.InvoiceMenu;
import com.hotel.Menu.ReportMenu;
import com.hotel.Menu.RoomMenu;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {

            showMainMenu();

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1:
                    RoomMenu.show(scanner);
                    break;

                case 2:
                    CustomerMenu.show(scanner);
                    break;

                case 3:
                    BookingMenu.show(scanner);
                    break;

                case 4:
                    InvoiceMenu.show(scanner);
                    break;

                case 5:
                    ReportMenu.show(scanner);
                    break;

                case 0:
                    System.out.println("Thank you for using Hotel Management System.");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static void showMainMenu() {

        System.out.println();
        System.out.println("========== HOTEL MANAGEMENT ==========");
        System.out.println("1. Room Management");
        System.out.println("2. Customer Management");
        System.out.println("3. Booking Management");
        System.out.println("4. Invoice Management");
        System.out.println("5. Report");
        System.out.println("0. Exit");
        System.out.print("Choose: ");

    }

}
