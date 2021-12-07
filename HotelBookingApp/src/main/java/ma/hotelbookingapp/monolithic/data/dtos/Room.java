package ma.hotelbookingapp.monolithic.data.dtos;

import java.io.Serializable;
import java.util.List;

import ma.hotelbookingapp.monolithic.data.entities.RoomType;
 
public class Room implements Serializable{

    private long id;

    private RoomType roomType;

    private Double surface;

    private int numberOfBeds;

    private int maxNumberOfGuests;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public Double getSurface() {
        return surface;
    }

    public void setSurface(Double surface) {
        this.surface = surface;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public int getMaxNumberOfGuests() {
        return maxNumberOfGuests;
    }

    public void setMaxNumberOfGuests(int maxNumberOfGuests) {
        this.maxNumberOfGuests = maxNumberOfGuests;
    }

    public List<String> getServicesOffered() {
        return servicesOffered;
    }

    public void setServicesOffered(List<String> servicesOffered) {
        this.servicesOffered = servicesOffered;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    private List<String> servicesOffered;

    private float price;

    
    protected Room(){}

    public Room(int roomNumber, int floorNumber, int buildingNumber, RoomType roomType, Double surface, int numberOfBeds, int maxNumberOfGuests, List<String> servicesOffered, float price){
    this.roomType = roomType;
    this.surface = surface;
    this.numberOfBeds = numberOfBeds;
    this.maxNumberOfGuests = maxNumberOfGuests;
    this.servicesOffered = servicesOffered;
    this.price = price;
    }   
}
