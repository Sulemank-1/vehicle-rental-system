import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        FleetManager manager = new FleetManager("Vehicle Rental");
        final String FLEET_FILE = "fleet.dat";

        manager.loadFleet(FLEET_FILE);

        boolean running = true;
        while (running) {
            System.out.println("\n=== " + manager.getAgencyName() + " Management ===");
            System.out.println("1. Provision New Car");
            System.out.println("2. Provision New Truck");
            System.out.println("3. Display Full Fleet Inventory Status");
            System.out.println("4. Check Out/Rent vehicle via License Plate");
            System.out.println("5. Check In/Return vehicle via License Plate");
            System.out.println("6. Calculate Daily Revenue from Active Rentals");
            System.out.println("7. Save fleet logs to file");
            System.out.print("Select choice: ");

            int choice;
            try {
                choice = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Choose a valid menu index.");
                input.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                    try {
                        System.out.print("Enter Plate: ");
                        String plate = input.next();
                        System.out.print("Enter Model: ");
                        input.nextLine();
                        String model = input.nextLine();
                        System.out.print("Enter Daily Rate ($): ");
                        double rate = input.nextDouble();
                        System.out.print("Include GPS Integration? (true/false): ");
                        boolean gps = input.nextBoolean();

                        manager.addVehicle(new Car(plate, model, rate, false, gps));
                        System.out.println("Success: Car unit added to fleet.");
                    } catch (InvalidRentalException e) {
                        System.out.println("Allocation Blocked: " + e.getMessage());
                    } catch (InputMismatchException e) {
                        System.out.println("Typing Format Violation. Operation aborted.");
                        input.nextLine();
                    }
                    break;

                case 2:
                    try {
                        System.out.print("Enter Plate: ");
                        String plate = input.next();
                        System.out.print("Enter Model: ");
                        input.nextLine();
                        String model = input.nextLine();
                        System.out.print("Enter Daily Rate ($): ");
                        double rate = input.nextDouble();
                        System.out.print("Enter Cargo Capacity Limit (Tons): ");
                        double tons = input.nextDouble();

                        manager.addVehicle(new Truck(plate, model, rate, false, tons));
                        System.out.println("Success: Truck unit added to fleet.");
                    } catch (InvalidRentalException e) {
                        System.out.println("Allocation Blocked: " + e.getMessage());
                    } catch (InputMismatchException e) {
                        System.out.println("Typing Format Violation. Operation aborted.");
                        input.nextLine();
                    }
                    break;

                case 3:
                    System.out.println("\n--- Current Active Fleet Status Inventory ---");
                    manager.displayFleetStatus();
                    break;

                case 4:
                    System.out.print("Enter license plate: ");
                    String checkoutPlate = input.next();
                    manager.processRental(checkoutPlate);
                    break;

                case 5:
                    System.out.print("Enter license plate: ");
                    String returnPlate = input.next();
                    manager.processReturn(returnPlate);
                    break;

                case 6:
                    System.out.printf("Current live operational cash-flow trend: $%.2f / day\n",
                            manager.calculateTotalFleetValue());
                    break;

                case 7:
                    manager.saveFleet(FLEET_FILE);
                    System.out.println("Fleet log saved to file.");
                    running = false;
                    break;

                default:
                    System.out.println("Select index numbers 1 through 7.");
            }
        }
        input.close();
    }
}