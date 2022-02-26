package entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/*@Entity
@Table(name = "bikes")*/
public class Bike extends Vehicle {
    public Bike() {
    }

    public Bike(long id, String type, String model, BigDecimal price, String fuelType) {
        super(id, type, model, price, fuelType);
    }
}
