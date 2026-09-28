package Menu;

import com.hotel.exception.DuplicateRoomException;
import com.hotel.exception.RoomNotFoundException;
import com.hotel.model.Room;
import com.hotel.model.StandardRoom;
import com.hotel.service.RoomService;

import java.util.List;
import java.util.Scanner;

public class RoomMenu {

    private static final RoomService roomService = new RoomService();

    public static void show(Scanner scanner) {

        while (true) {

            System.out.println("\n========== ROOM MANAGEMENT ==========");
            System.out.println("1. Add Room");
            System.out.println("2. View Rooms");
            System.out.println("3. Find Room");
            System.out.println("4. Update Room");
            System.out.println("5. Delete Room");
            System.out.println("0. Back");
            System.out.print("Choose: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1:
                    addRoom(scanner);
                    break;

                case 2:
                    viewRooms();
                    break;

                case 3:
                    findRoom(scanner);
                    break;

                case 4:
                    updateRoom(scanner);
                    break;

                case 5:
                    deleteRoom(scanner);
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    /**
     * Add Room
     */
    private static void addRoom(Scanner scanner) {

        try {

            System.out.println("\n========== ADD ROOM ==========");

            System.out.print("Room ID: ");
            String id = scanner.nextLine();

            System.out.print("Room Number: ");
            String roomNumber = scanner.nextLine();

            System.out.print("Base Price: ");
            double basePrice = Double.parseDouble(scanner.nextLine());

            System.out.print("Max Guests: ");
            int maxGuests = Integer.parseInt(scanner.nextLine());

            Room room = new StandardRoom(
                    id,
                    roomNumber,
                    basePrice,
                    maxGuests
            );

            roomService.addRoom(room);

            System.out.println("Add room successfully!");

        } catch (DuplicateRoomException e) {

            System.out.println(e.getMessage());

        } catch (NumberFormatException e) {

            System.out.println("Invalid number!");

        }
    }

    /**
     * View Rooms
     */
    private static void viewRooms() {

        System.out.println("\n========== ROOM LIST ==========");

        List<Room> rooms = roomService.getAllRooms();

        if (rooms.isEmpty()) {

            System.out.println("No rooms found.");
            return;

        }

        for (Room room : rooms) {

            System.out.println(room);

        }

    }

    /**
     * Find Room
     */
    private static void findRoom(Scanner scanner) {

        try {

            System.out.println("\n========== FIND ROOM ==========");

            System.out.print("Enter Room ID: ");

            String id = scanner.nextLine();

            Room room = roomService.findRoomById(id);

            System.out.println(room);

        } catch (RoomNotFoundException e) {

            System.out.println(e.getMessage());

        }

    }

    /**
     * Update Room
     */
    private static void updateRoom(Scanner scanner) {

        try {

            System.out.println("\n========== UPDATE ROOM ==========");

            System.out.print("Enter Room ID: ");

            String id = scanner.nextLine();

            Room room = roomService.findRoomById(id);

            System.out.println("\nCurrent Information");

            System.out.println(room);

            System.out.print("New Room Number: ");
            room.setRoomNumber(scanner.nextLine());

            System.out.print("New Base Price: ");
            room.setBasePrice(Double.parseDouble(scanner.nextLine()));

            if (room instanceof StandardRoom) {

                StandardRoom standardRoom = (StandardRoom) room;

                System.out.print("New Max Guests: ");

                standardRoom.setMaxGuests(
                        Integer.parseInt(scanner.nextLine())
                );

            }

            roomService.updateRoom(room);

            System.out.println("Update room successfully!");

        } catch (RoomNotFoundException e) {

            System.out.println(e.getMessage());

        } catch (NumberFormatException e) {

            System.out.println("Invalid number!");

        }

    }

    /**
     * Delete Room
     */
    private static void deleteRoom(Scanner scanner) {

        try {

            System.out.println("\n========== DELETE ROOM ==========");

            System.out.print("Enter Room ID: ");

            String id = scanner.nextLine();

            roomService.deleteRoom(id);

            System.out.println("Delete room successfully!");

        } catch (RoomNotFoundException e) {

            System.out.println(e.getMessage());

        }

    }

}