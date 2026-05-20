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


}
