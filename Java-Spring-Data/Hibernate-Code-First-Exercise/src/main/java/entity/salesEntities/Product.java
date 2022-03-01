package entity.salesEntities;




import entity.BaseEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

//@Entity
@Table(name = "products")
public class Product extends BaseEntity {

    @Column(name = "first_name", length = 50)
    private String firstName;

    @Column(name = "quantity")
    private Double quantity;

    @Column(name = "price", precision = 10, scale = 3)
    private BigDecimal price;

    @Column(name = "sales")
    @OneToMany(mappedBy = "product",cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Set<Sale> sales;

    public Product(){
        this.sales = new HashSet<>();
    };

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Set<Sale> getSales() {
        return sales;
    }

    public void setSales(Set<Sale> sales) {
        this.sales = sales;
    }
}
