package com.hotel.Menu;

import com.hotel.exception.DuplicateRoomException;
import com.hotel.exception.RoomNotFoundException;
import com.hotel.model.Room;
import com.hotel.model.StandardRoom;
import com.hotel.service.RoomService;
import com.hotel.model.SuiteRoom;
import com.hotel.util.PriceUtil;

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

            System.out.println("Room Type:");
            System.out.println("1. Standard Room");
            System.out.println("2. Suite Room");
            System.out.print("Choose: ");
            int type = Integer.parseInt(scanner.nextLine());

            Room room;

            if (type == 1) {

                System.out.print("Max Guests: ");
                int maxGuests = Integer.parseInt(scanner.nextLine());

                room = new StandardRoom(
                        id,
                        roomNumber,
                        basePrice,
                        maxGuests
                );

            } else if (type == 2) {

                System.out.print("Has Jacuzzi (true/false): ");
                boolean hasJacuzzi = Boolean.parseBoolean(scanner.nextLine());

                System.out.print("Extra Service Fee: ");
                double extraServiceFee = Double.parseDouble(scanner.nextLine());

                room = new SuiteRoom(
                        id,
                        roomNumber,
                        basePrice,
                        hasJacuzzi,
                        extraServiceFee
                );

            } else {

                System.out.println("Invalid room type!");
                return;

            }

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

            System.out.println("----------------------------------------");
            System.out.println("Room ID      : " + room.getId());
            System.out.println("Room Number  : " + room.getRoomNumber());
            System.out.println("Base Price   : " + PriceUtil.format(room.getBasePrice()));
            System.out.println("Final Price  : " + PriceUtil.format(room.calculatePrice()));

            if (room instanceof StandardRoom) {

                StandardRoom standard = (StandardRoom) room;

                System.out.println("Room Type    : Standard Room");
                System.out.println("Max Guests   : " + standard.getMaxGuests());

            } else if (room instanceof SuiteRoom) {

                SuiteRoom suite = (SuiteRoom) room;

                System.out.println("Room Type    : Suite Room");
                System.out.println("Has Jacuzzi  : " + suite.isHasJacuzzi());
                System.out.println("Extra Fee    : " + PriceUtil.format(suite.getExtraServiceFee()));

            }

            System.out.println("----------------------------------------");
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

            System.out.println("\n========== ROOM INFORMATION ==========");
            System.out.println("Room ID      : " + room.getId());
            System.out.println("Room Number  : " + room.getRoomNumber());
            System.out.println("Base Price   : " + PriceUtil.format(room.getBasePrice()));
            System.out.println("Final Price  : " + PriceUtil.format(room.calculatePrice()));

            if (room instanceof StandardRoom) {

                StandardRoom standard = (StandardRoom) room;

                System.out.println("Room Type    : Standard Room");
                System.out.println("Max Guests   : " + standard.getMaxGuests());

            } else if (room instanceof SuiteRoom) {

                SuiteRoom suite = (SuiteRoom) room;

                System.out.println("Room Type    : Suite Room");
                System.out.println("Has Jacuzzi  : " + suite.isHasJacuzzi());
                System.out.println("Extra Fee    : " + PriceUtil.format(suite.getExtraServiceFee()));

            }

            System.out.println("----------------------------------------");

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

            System.out.println("\n========== CURRENT INFORMATION ==========");
            System.out.println("Room ID      : " + room.getId());
            System.out.println("Room Number  : " + room.getRoomNumber());
            System.out.println("Base Price   : " + PriceUtil.format(room.getBasePrice()));
            System.out.println("Final Price  : " + PriceUtil.format(room.calculatePrice()));

            if (room instanceof StandardRoom) {

                StandardRoom standard = (StandardRoom) room;

                System.out.println("Room Type    : Standard Room");
                System.out.println("Max Guests   : " + standard.getMaxGuests());

            } else if (room instanceof SuiteRoom) {

                SuiteRoom suite = (SuiteRoom) room;

                System.out.println("Room Type    : Suite Room");
                System.out.println("Has Jacuzzi  : " + suite.isHasJacuzzi());
                System.out.println("Extra Fee    : " + PriceUtil.format(suite.getExtraServiceFee()));

            }

            System.out.println("----------------------------------------");

            System.out.print("New Room Number: ");
            room.setRoomNumber(scanner.nextLine());

            System.out.print("New Base Price: ");
            room.setBasePrice(Double.parseDouble(scanner.nextLine()));

            if (room instanceof StandardRoom) {

                StandardRoom standard = (StandardRoom) room;

                System.out.print("New Max Guests: ");
                standard.setMaxGuests(Integer.parseInt(scanner.nextLine()));

            } else if (room instanceof SuiteRoom) {

                SuiteRoom suite = (SuiteRoom) room;

                System.out.print("Has Jacuzzi (true/false): ");
                suite.setHasJacuzzi(Boolean.parseBoolean(scanner.nextLine()));

                System.out.print("New Extra Service Fee: ");
                suite.setExtraServiceFee(
                        Double.parseDouble(scanner.nextLine())
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