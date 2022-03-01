package entity.billsEntities;

        import entity.BaseEntity;

        import javax.persistence.Column;
        import javax.persistence.Entity;
        import javax.persistence.Table;

//@Entity
@Table(name = "bank_users")
public class User extends BaseEntity {

    @Column(name = "first_name", length = 50)
    private String firstName;
    @Column(name = "last_name", length = 50)
    private String lastName;
    @Column(length = 20)
    private String password;
    @Column(length = 30)
    private String email;

    public User(){};

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
