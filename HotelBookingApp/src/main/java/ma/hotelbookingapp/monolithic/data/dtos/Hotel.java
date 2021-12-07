package ma.hotelbookingapp.monolithic.data.dtos;

import java.io.Serializable;

public class Hotel implements Serializable{
    
    
    private static final long serialVersionUID = 1L;
    
    private String hotelName;

    private int starsRating;

    private String address;

    private String city;

    public float getDistanceFromCenter() {
        return distanceFromCenter;
    }

    public void setDistanceFromCenter(float distanceFromCenter) {
        this.distanceFromCenter = distanceFromCenter;
    }

    private String phoneNumber;

    private String emailAddress;

    private float distanceFromCenter;

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

    protected Hotel() { }

    public Hotel(String hotelName, int starsRating, String address, String city, String phoneNumber, String emailAddress){
        this.hotelName = hotelName;
        this.starsRating = starsRating;
        this.address = address;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }
}
