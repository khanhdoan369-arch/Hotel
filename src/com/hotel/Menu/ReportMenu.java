package com.hotel.Menu;

import com.hotel.service.ReportService;

import java.util.Scanner;

public class ReportMenu {

    private static final ReportService reportService =
            new ReportService();

    public static void show(Scanner scanner) {

        while (true) {

            System.out.println("\n========== REPORT ==========");
            System.out.println("1. Revenue Report");
            System.out.println("2. Booking Report");
            System.out.println("0. Back");
            System.out.print("Choose: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1:

                    reportService.revenueReport();
                    break;

                case 2:

                    reportService.bookingReport();
                    break;

                case 0:

                    return;

                default:

                    System.out.println("Invalid choice!");

            }

        }

    }

}
