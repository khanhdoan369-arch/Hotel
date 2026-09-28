package Main;

import Menu.*;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {

            System.out.println("========== HOTEL ==========");
            System.out.println("1. Room");
            System.out.println("2. Customer");
            System.out.println("3. Booking");
            System.out.println("4. Invoice");
            System.out.println("5. Report");
            System.out.println("0. Exit");

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
                    return;
            }
        }
    }
}