package entity.salesEntities;


import entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

//@Entity
@Table(name = "customers")
public class Customer extends BaseEntity {

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "email", length = 70)
    private String email;

    @Column(name = "credit_card_number", length = 100)
    private String creditCardNumber;

    @Column(name = "sales")
    @OneToMany(mappedBy = "customer")
    private Set<Sale> sales;


    public Customer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }
}
