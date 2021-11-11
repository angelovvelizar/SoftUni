package Exercise.VehicleExtension;

public class Bus extends Vehicle {
    private static final double ADDITIONAL_CONSUMPTION = 1.4;

    protected Bus(double fuelQuantity, double consumption, double tankCapacity) {
        super(fuelQuantity, consumption + ADDITIONAL_CONSUMPTION, tankCapacity);
    }

    public String driveWithoutPassengers(double distance){
        this.setConsumption(getConsumption() - ADDITIONAL_CONSUMPTION);
        String out = super.drive(distance);
        this.setConsumption(getConsumption() + ADDITIONAL_CONSUMPTION);

        return out;
    }



}
