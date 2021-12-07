package ma.hotelbookingapp.monolithic.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import java.util.List;


@Entity
@Table(name="Hotel")
public class Hotel extends BaseEntity {

    private static final long serialVersionUID = 3959935433240472748L;

    @Column(name="hotelname")
    @NotNull
    protected String hotelName;

    @Column(name="starsRating")
    @NotNull
    protected int starsRating;


    @Column(name="address")
    @NotNull
    protected String address;


    @Column(name="city")
    @NotNull
    protected String city;

    
    @Column(name="phoneNumber")
    @NotNull
    protected String phoneNumber;

    
    @Column(name="emailAddress")
    @NotNull
    protected String emailAddress;

    @Column(name = "distanceFromCenter")
    @NotNull
    protected float distanceFromCenter;

    
    @Column(name="rooms")
    @OneToMany(mappedBy = "hotel", fetch = FetchType.LAZY)
    private List<Room> rooms;

    @Column(name="discounts")
    @OneToMany(mappedBy = "hotel", fetch = FetchType.LAZY)
    private List<Discount> discounts;

    
    @Column(name="reviews")
    @OneToMany(mappedBy = "hotelReviewed", fetch = FetchType.LAZY)
    private List<Review> reviews;
    
    public Hotel() { }

    public Hotel(String hotelName, int starsRating, String address, String city, String phoneNumber, String emailAddress, List<Review> reviews, List<Room> rooms, float distanceFromCenter){
        this.hotelName = hotelName;
        this.starsRating = starsRating;
        this.address = address;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.rooms = rooms;
        this.reviews = reviews;
        this.distanceFromCenter = distanceFromCenter;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getStarsRating() {
        return starsRating;
    }

    public void setStarsRating(int starsRating) {
        this.starsRating = starsRating;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public float getDistanceFromCenter() {
        return distanceFromCenter;
    }

    public void setDistanceFromCenter(float distanceFromCenter) {
        this.distanceFromCenter = distanceFromCenter;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public List<Discount> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(List<Discount> discounts) {
        this.discounts = discounts;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

}
