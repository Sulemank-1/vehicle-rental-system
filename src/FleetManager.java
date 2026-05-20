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


}
