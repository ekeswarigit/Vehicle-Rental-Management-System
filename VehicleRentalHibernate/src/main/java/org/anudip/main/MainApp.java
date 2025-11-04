package org.anudip.main;
import org.anudip.dao.*;
import org.anudip.model.*;
import java.util.*;

public class MainApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        VehicleDAO vehicleDAO = new VehicleDAO();
        CustomerDAO customerDAO = new CustomerDAO();
        BookingDAO bookingDAO = new BookingDAO();

        System.out.println("=== VEHICLE RENTAL MANAGEMENT SYSTEM ===");

        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Add Vehicle");
            System.out.println("2. Register Customer");
            System.out.println("3. Show All Vehicles");
            System.out.println("4. Show All Customers");
            System.out.println("5. Make Booking");
            System.out.println("6. Show All Bookings");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Vehicle Name: ");
                    String vname = sc.nextLine();
                    System.out.print("Enter Type (Car/Bike): ");
                    String type = sc.nextLine();
                    System.out.print("Enter Rent per Day: ");
                    double rent = sc.nextDouble();
                    sc.nextLine();
                    Vehicle v = new Vehicle(vname, type, rent, "Available");
                    vehicleDAO.addVehicle(v);
                    break;

                case 2:
                    System.out.print("Enter Customer Name: ");
                    String cname = sc.nextLine();
                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();
                    System.out.print("Enter Password: ");
                    String pass = sc.nextLine();
                    Customer c = new Customer(cname, email, pass);
                    customerDAO.registerCustomer(c);
                    break;

                case 3:
                    System.out.println("\n--- All Vehicles ---");
                    List<Vehicle> vehicles = vehicleDAO.getAllVehicles();
                    for (Vehicle veh : vehicles)
                        System.out.println(veh);
                    break;

                case 4:
                    System.out.println("\n--- All Customers ---");
                    List<Customer> customers = customerDAO.getAllCustomers();
                    for (Customer cust : customers)
                        System.out.println(cust);
                    break;

                case 5:
                    System.out.println("\n--- Book a Vehicle ---");
                    System.out.print("Enter Customer ID(1st Customer): ");
                    int cid = sc.nextInt();
                    System.out.print("Enter Vehicle ID(1st vehicle): ");
                    int vid = sc.nextInt();
                    System.out.print("Enter Number of Days: ");
                    int days = sc.nextInt();
                    sc.nextLine();

                    Customer customer = customerDAO.getAllCustomers()
                            .stream().filter(x -> x.getCustomer_id() == cid).findFirst().orElse(null);
                    Vehicle vehicle = vehicleDAO.getAllVehicles()
                            .stream().filter(x -> x.getVehicle_id() == vid).findFirst().orElse(null);

                    if (customer != null && vehicle != null) {
                        double total = vehicle.getRent_per_day() * days;
                        Booking b = new Booking(customer, vehicle, new Date(), new Date(), total, "Booked");
                        bookingDAO.addBooking(b);
                        System.out.println("✅ Booking confirmed for " + customer.getName() + " - Rs." + total);
                    } else {
                        System.out.println("❌ Invalid Customer ID or Vehicle ID!");
                    }
                    break;

                case 6:
                    System.out.println("\n--- All Bookings ---");
                    List<Booking> bookings = bookingDAO.getAllBookings();
                    for (Booking b : bookings)
                        System.out.println(b);
                    break;

                case 7:
                    System.out.println("Thank you for using Vehicle Rental System!");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("❌ Invalid choice, please try again.");
            }
        }
    }
}

