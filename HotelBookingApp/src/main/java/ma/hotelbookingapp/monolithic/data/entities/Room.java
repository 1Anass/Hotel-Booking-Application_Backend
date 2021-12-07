package ma.hotelbookingapp.monolithic.data.entities;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Room")
public class Room extends BaseEntity {

    @Column(name = "roomnumber")
    @NotNull
    private int roomNumber;

    @Column(name = "floornumber")
    @NotNull
    private int floorNumber;

    @Column(name = "buildingnumber")
    @NotNull
    private int buildingNumber;

    // @Column(name="hotel")
    @ManyToOne
    @NotNull
    private Hotel hotel;

    @ManyToOne
    private Reservation reservation;


    @Column(name = "roomtype")
    @NotNull
    private RoomType roomType;

    @Column(name = "surface")
    @NotNull
    private Double surface;

    @Column(name = "numberofbeds")
    @NotNull
    private int numberOfBeds;

    @Column(name = "maxnumberofguests")
    @NotNull
    private int maxNumberOfGuests;

    @Column(name = "price")
    @NotNull
    private float price;

    @Column(name = "serviceoffered")
    @OneToMany(mappedBy = "room", fetch = FetchType.LAZY)
    private List<ServiceOffered> servicesOffered;

    public Room(int roomNumber, int floorNumber, int buildingNumber, Hotel hotel, RoomType roomType, Double surface,
            int numberOfBeds, int maxNumberOfGuests, float price) {
        this.roomNumber = roomNumber;
        this.floorNumber = floorNumber;
        this.buildingNumber = buildingNumber;
        this.hotel = hotel;
        this.roomType = roomType;
        this.surface = surface;
        this.numberOfBeds = numberOfBeds;
        this.maxNumberOfGuests = maxNumberOfGuests;
        this.price = price;
    }

  
    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public int getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(int buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
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

    public List<ServiceOffered> getServicesOffered() {
        return servicesOffered;
    }

    public void setServicesOffered(List<ServiceOffered> servicesOffered) {
        this.servicesOffered = servicesOffered;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    protected Room() {
    }

    

}
