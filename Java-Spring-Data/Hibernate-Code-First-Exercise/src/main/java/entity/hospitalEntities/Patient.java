package entity.hospitalEntities;



import entity.BaseEntity;
import validations.DateValidation;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

//@Entity
@Table(name = "patients")
public class Patient extends BaseEntity {
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private LocalDate birthDate;

    @OneToOne(optional = false)
    private Diagnose diagnose;

    @OneToMany(mappedBy = "patient")
    private Set<Visitation> visitations;

    @Column(name = "picture", columnDefinition = "BLOB")
    private String picture;

    @Column(name = "has_medical_insurance")
    private Boolean hasMedicalInsurance;

    public Patient(){
        this.visitations = new HashSet<>();
    };

    public Patient(String firstName, String lastName, String address, String email, LocalDate birthDate, String picture, Boolean hasMedicalInsurance) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAddress(address);
        this.setEmail(email);
        this.setBirthDate(birthDate);
        this.picture = picture;
        this.hasMedicalInsurance = hasMedicalInsurance;
    }

    @Column(name = "first_name", length = 50, nullable = false)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if(firstName != null && firstName.length() > 1 ) {
            this.firstName = firstName;
        }else{
            throw new IllegalArgumentException("Invalid first name!");
        }
    }

    @Column(name = "last_name", length = 50, nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if(lastName != null && lastName.length() > 1 ) {
            this.lastName = lastName;
        }else{
            throw new IllegalArgumentException("Invalid last name!");
        }
    }


    @Column(name = "address", length = 150, nullable = false)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if(address != null && address.length() > 5) {
            this.address = address;
        }else {
            throw new IllegalArgumentException("Invalid address!");
        }
    }

    @Column(name = "email", length = 70)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(email.length() < 5 || !email.contains("@")){
            throw new IllegalArgumentException("Invalid email!");
        }

        this.email = email;
    }

    @Column(name = "date_of_birth", nullable = false)
    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        if(DateValidation.isDateValid(birthDate.toString())) {
            this.birthDate = birthDate;
        }
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Boolean getHasMedicalInsurance() {
        return hasMedicalInsurance;
    }

    public void setHasMedicalInsurance(Boolean hasMedicalInsurance) {
        this.hasMedicalInsurance = hasMedicalInsurance;
    }


    public Set<Visitation> getVisitations() {
        return visitations;
    }

    public void setVisitations(Set<Visitation> visitations) {
        this.visitations = visitations;
    }
}
