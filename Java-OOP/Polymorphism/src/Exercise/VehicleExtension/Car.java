package Exercise.VehicleExtension;

import java.text.DecimalFormat;

public class Car extends Vehicle {
    private static final double ADDITIONAL_CONSUMPTION = 0.9;


    protected Car(double fuelQuantity, double consumption, double tankCapacity) {
        super(fuelQuantity, consumption + ADDITIONAL_CONSUMPTION, tankCapacity);
    }
}
