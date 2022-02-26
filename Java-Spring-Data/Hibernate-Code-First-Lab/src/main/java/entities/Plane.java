package entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/*@Entity
@Table(name = "planes")*/
public class Plane extends Vehicle{
    private Integer passengerCapacity;

    public Plane() {
    }

    public Plane(long id, String type, String model, BigDecimal price, String fuelType, int passengerCapacity) {
        super(id, type, model, price, fuelType);
        this.passengerCapacity = passengerCapacity;
    }

    public void setPassengerCapacity(Integer passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public Integer getPassengerCapacity() {
        return passengerCapacity;
    }
}
