package com.hotel.Menu;

import com.hotel.exception.CustomerNotFoundException;
import com.hotel.model.Customer;
import com.hotel.service.CustomerService;

import java.util.List;
import java.util.Scanner;

public class CustomerMenu {

    private static final CustomerService service = new CustomerService();

    public static void show(Scanner scanner) {

        while (true) {

            System.out.println("\n========== CUSTOMER MANAGEMENT ==========");
            System.out.println("1. Add Customer");
            System.out.println("2. View Customers");
            System.out.println("3. Find Customer");
            System.out.println("4. Update Customer");
            System.out.println("5. Delete Customer");
            System.out.println("0. Back");
            System.out.print("Choose: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1:
                    addCustomer(scanner);
                    break;

                case 2:
                    viewCustomers();
                    break;

                case 3:
                    findCustomer(scanner);
                    break;

                case 4:
                    updateCustomer(scanner);
                    break;

                case 5:
                    deleteCustomer(scanner);
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // ================= ADD =================

    private static void addCustomer(Scanner scanner) {

        System.out.print("Customer ID: ");
        String id = scanner.nextLine();

        System.out.print("Full Name: ");
        String name = scanner.nextLine();

        System.out.print("Phone: ");
        String phone = scanner.nextLine();

        System.out.print("Identity Number: ");
        String identity = scanner.nextLine();

        System.out.print("VIP (true/false): ");
        boolean vip = Boolean.parseBoolean(scanner.nextLine());

        Customer customer = new Customer(id, name, phone, identity, vip);

        service.addCustomer(customer);

        System.out.println("Customer added successfully.");
    }

    // ================= VIEW =================

    private static void viewCustomers() {

        List<Customer> customers = service.getAllCustomers();

        if (customers.isEmpty()) {

            System.out.println("No customers found.");
            return;
        }

        for (Customer customer : customers) {

            System.out.println(customer);

        }
    }

    // ================= FIND =================

    private static void findCustomer(Scanner scanner) {

        System.out.print("Enter Customer ID: ");
        String id = scanner.nextLine();

        try {

            Customer customer = service.findCustomerById(id);

            System.out.println(customer);

        } catch (CustomerNotFoundException e) {

            System.out.println(e.getMessage());

        }

    }

    // ================= UPDATE =================

    private static void updateCustomer(Scanner scanner) {

        System.out.print("Enter Customer ID: ");
        String id = scanner.nextLine();

        try {

            Customer customer = service.findCustomerById(id);

            System.out.print("New Full Name: ");
            customer.setFullName(scanner.nextLine());

            System.out.print("New Phone: ");
            customer.setPhone(scanner.nextLine());

            System.out.print("New Identity Number: ");
            customer.setIdentityNumber(scanner.nextLine());

            System.out.print("VIP (true/false): ");
            customer.setVip(Boolean.parseBoolean(scanner.nextLine()));

            service.updateCustomer(customer);

            System.out.println("Customer updated successfully.");

        } catch (CustomerNotFoundException e) {

            System.out.println(e.getMessage());

        }

    }

    // ================= DELETE =================

    private static void deleteCustomer(Scanner scanner) {

        System.out.print("Enter Customer ID: ");
        String id = scanner.nextLine();

        try {

            service.deleteCustomer(id);

            System.out.println("Customer deleted successfully.");

        } catch (CustomerNotFoundException e) {

            System.out.println(e.getMessage());

        }

    }

}