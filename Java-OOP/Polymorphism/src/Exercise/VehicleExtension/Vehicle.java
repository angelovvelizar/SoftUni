package Exercise.VehicleExtension;

import java.text.DecimalFormat;

public abstract class Vehicle {
    private double fuelQuantity;
    private double consumption;
    private double tankCapacity;

    protected Vehicle(double fuelQuantity, double consumption, double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.consumption = consumption;
        this.tankCapacity = tankCapacity;
    }

    public String drive(double distance){
        double fuelNeeded = distance * this.consumption;
        if(fuelNeeded > this.fuelQuantity){
            return this.getClass().getSimpleName() + " needs refueling";
        }

        this.fuelQuantity -= fuelNeeded;

        return this.getClass().getSimpleName() + " travelled "
                + new DecimalFormat("#.##").format(distance)
                + " km";
    }

    public void refuel(double liters){
        if(liters <= 0){
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        if(this.fuelQuantity + liters > this.tankCapacity){
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }

        this.fuelQuantity += liters;
    }

    protected void setConsumption(double consumption) {
        this.consumption = consumption;
    }

    public double getConsumption() {
        return consumption;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f",this.getClass().getSimpleName(), this.fuelQuantity);
    }
}
