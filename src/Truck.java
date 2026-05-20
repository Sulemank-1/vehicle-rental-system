public class Truck extends Vehicle{
    //Data Fields
    private double cargoCapacity;

    //Constructor
    public Truck(String licensePlate, String model, double dailyRate, boolean isRented, double cargoCapacity){
        super(licensePlate, model, dailyRate, isRented);
        this.cargoCapacity = cargoCapacity;
    }

    //Getters
    public double getCargoCapacity() {
        return cargoCapacity;
    }

    //Setter
    public void setCargoCapacity(double cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    //Methods
    @Override
    public double calculateRentalCost(int days){
        return (getDailyRate() * days) + (getCargoCapacity() * 15 * days);
    }

    @Override
    public String toString(){
        return super.toString() + "| Cargo Capacity: " + getCargoCapacity();
    }
}
