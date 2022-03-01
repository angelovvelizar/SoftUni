package entity.hospitalEntities;


import entity.BaseEntity;
import validations.DateValidation;

import javax.persistence.*;
import java.time.LocalDate;

//@Entity
@Table(name = "visitations")
public class Visitation  extends BaseEntity {

    private LocalDate date;
    private String comments;

    @ManyToOne
    private Patient patient;

    public Visitation(){};

    @Column(name = "date")
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        if(DateValidation.isDateValid(date.toString())) {
            this.date = date;
        }
    }

    @Column(name = "comments", columnDefinition = "TEXT")
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

}
