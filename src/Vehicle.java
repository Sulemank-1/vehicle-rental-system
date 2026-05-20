public abstract class Vehicle {
    //Data Fields
    private String licensePlate;
    private String model;
    private double dailyRate;
    private boolean isRented;

    //Constructor
    public Vehicle(String licensePlate, String model, double dailyRate, boolean isRented){
        this.licensePlate = licensePlate;
        this.model = model;
        this.dailyRate = dailyRate;
        this.isRented = isRented;
    }

    //Getters
    public String getLicensePlate() {
        return licensePlate;
    }

    public String getModel() {
        return model;
    }

    public double getDailyRate() {
        return dailyRate;
    }

    public boolean isRented() {
        return isRented;
    }

    //Setters
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setDailyRate(double dailyRate) {
        this.dailyRate = dailyRate;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }

    //Methods
    public void rentVehicle(){
        isRented = true;
    }

    public void returnVehicle(){
        isRented = false;
    }

    public abstract double calculateRentalCost(int days);

    @Override
    public String toString(){
        return "Licence Plate: " + getLicensePlate() + "| Model: " + getModel() + "| Daily Rate: " + getDailyRate() + "| Rented Status " + ((isRented()) ? "Rented" : "Not Rented");
    }
}
