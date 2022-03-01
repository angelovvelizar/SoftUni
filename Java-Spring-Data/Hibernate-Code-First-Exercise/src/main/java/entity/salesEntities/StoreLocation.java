package entity.salesEntities;


import entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

//@Entity
@Table(name = "store_location")
public class StoreLocation  extends BaseEntity {

    @Column(name = "location_name", length = 60)
    private String locationName;

    @Column(name = "sales")
    @OneToMany(mappedBy = "storeLocation")
    private Set<Sale> sales;


    public StoreLocation() {
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }
}
