package entity.billsEntities;


import entity.BaseEntity;

import javax.persistence.*;

//@Entity
@Table(name = "billing_details")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class BillingDetail extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String number;

    @ManyToOne
    private User owner;

    public BillingDetail(){};

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
