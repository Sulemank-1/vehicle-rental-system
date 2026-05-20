import java.util.ArrayList;

public class FleetManager {
    //Data Fields
    private String agencyName;
    private ArrayList<Vehicle> fleet;

    //Constructor
    public FleetManager(String agencyName){
        this.agencyName = agencyName;
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
            if (v.getLicensePlate().trim().equalsIgnoreCase(v.getLicensePlate())){
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


}
