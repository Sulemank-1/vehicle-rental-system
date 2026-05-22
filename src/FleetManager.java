import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FleetManager {
    //Data Fields
    private String agencyName;
    private ArrayList<Vehicle> fleet;

    //Constructor
    public FleetManager(String agencyName){
        this.agencyName = agencyName;
        fleet = new ArrayList<>();
    }

    //Getters
    public String getAgencyName() {
        return agencyName;
    }

    //Setters
    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    //Methods
    public void addVehicle(Vehicle v){
        for (Vehicle vehicle: fleet)
            if (vehicle.getLicensePlate().trim().equalsIgnoreCase(v.getLicensePlate())){
                System.out.println("Duplicate Licence Plate");
                return;
            }
        fleet.add(v);
    }

    public boolean processRental(String plate) {
        for (Vehicle vehicle : fleet) {
            if (vehicle.getLicensePlate().trim().equalsIgnoreCase(plate.trim())) {
                if (!vehicle.isRented()) {
                    vehicle.rentVehicle();
                    System.out.println("Success: Vehicle " + plate + " has been checked out.");
                    return true;
                } else {
                    System.out.println("Vehicle is already rented out.");
                    return false;
                }
            }
        }
        System.out.println("License plate not found in fleet records.");
        return false;
    }

    public boolean processReturn(String plate) {
        for (Vehicle vehicle : fleet) {
            if (vehicle.getLicensePlate().trim().equalsIgnoreCase(plate.trim())) {
                if (vehicle.isRented()) {
                    vehicle.returnVehicle();
                    System.out.println("Vehicle returned");
                    return true;
                } else {
                    System.out.println("Vehicle is not rented out.");
                    return false;
                }
            }
        }
        System.out.println("License plate not found in fleet records.");
        return false;
    }

    public double calculateTotalFleetValue(){
        double sum = 0.0;
        for (Vehicle vehicle: fleet)
            if (vehicle.isRented())
                sum += vehicle.getDailyRate();
        return sum;
    }

    public void displayFleetStatus(){
        for (Vehicle vehicle: fleet)
            System.out.println(vehicle);
    }

    public void saveFleet(String filename){
        try (PrintWriter output = new PrintWriter(filename)){
            for (Vehicle v: fleet){
                if (v instanceof Car)
                    output.println("CAR," + v.getLicensePlate() + "," + v.getModel() + "," + v.getDailyRate() + "," + (v.isRented() ? "Rented":"Not Rented") + "," +  (((Car) v).getHasGPS()? "Has GPS": "Doesn't have GPS"));
                else if (v instanceof Truck)
                    output.println("TRUCK," + v.getLicensePlate() + "," + v.getModel() + "," + v.getDailyRate() + "," + (v.isRented() ? "Rented":"Not Rented") + "," + ((Truck) v).getCargoCapacity());
            }
        }catch (IOException ex){
            System.out.println("Data couldn't be saved in file");
        }
    }




}
