package ma.hotelbookingapp.monolithic.data.entities;

import java.util.List;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Entity
@Table(name = "User_")
public class User_ extends BaseEntity {

    //private static final long serialVersionUID = -2323571384056059081L;

    
    @Column(name="username")
    @NotNull
    protected String username;

    
    @Column(name="password")
    @NotNull
    protected String password;

    
    @Column(name="firstname")
    @NotNull
    protected String firstName;

    
    @Column(name="lastname")
    @NotNull
    protected String lastName;

    
    @Column(name="emailaddress")
    @NotNull
    protected String emailAddress;

    
    @Column(name="reservations")
    @OneToMany(mappedBy = "user")
    private List<Reservation> reservations;

    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    

    protected User_() {
    }

    public User_(String username, String password, String firstName, String lastName, String emailAddress) {
        this.username = username;
        this.password = new BCryptPasswordEncoder().encode(password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
    }
/*
    public String getFirstName() {
        return firstName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */

    /*
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    /*
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    */
}