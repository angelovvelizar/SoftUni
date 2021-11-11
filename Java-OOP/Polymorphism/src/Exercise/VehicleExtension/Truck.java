package Exercise.VehicleExtension;

import java.text.DecimalFormat;

public class Truck extends Vehicle {
    private static final double ADDITIONAL_CONSUMPTION = 1.6;

    protected Truck(double fuelQuantity, double consumption, double tankCapacity) {
        super(fuelQuantity, consumption + ADDITIONAL_CONSUMPTION, tankCapacity);
    }


    @Override
    public void refuel(double liters) {
        super.refuel(liters * 0.95);
    }
}

