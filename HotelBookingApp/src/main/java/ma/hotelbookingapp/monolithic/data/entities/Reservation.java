package ma.hotelbookingapp.monolithic.data.entities;

import java.util.Date;
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

import ma.hotelbookingapp.monolithic.data.dtos.StayPlan; 

@Entity 
@Table(name="Reservation")
public class Reservation extends BaseEntity{

    @Column(name="dateOfReservation")
    @NotNull
    private Date dateOfReservation;

    @Column(name="startdate")
    @NotNull
    private Date startDate;

    
    @Column(name="enddate")
    @NotNull
    private Date endDate;

    private ReservationStatus reservationStatus;
    //@Column(name="user")
    @ManyToOne(fetch=FetchType.LAZY)
    private User_ user;

    
    @Column(name="rooms")
    @OneToMany(mappedBy = "reservation")
    private List<Room> rooms;

    protected Reservation() {}

    public Reservation(StayPlan stayPlan, User_ user){
        this.user = user;
        if(stayPlan.getSelectedRooms() != null){

        }
    }
    
    public Date getDateOfReservation() {
        return dateOfReservation;
    }

    public void setDateOfReservation(Date dateOfReservation) {
        this.dateOfReservation = dateOfReservation;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public ReservationStatus getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(ReservationStatus reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    public User_ getUser() {
        return user;
    }

    public void setUser(User_ user) {
        this.user = user;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public Reservation(Date dateOfReservation, User_ user, ReservationStatus reservationStatus,Date startDate,Date endDate){
        this.dateOfReservation = dateOfReservation;
        this.user = user;
        this.reservationStatus = reservationStatus;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public void updateStatus(ReservationStatus newStatus) throws IllegalStateException{
        if(newStatus == ReservationStatus.USED || newStatus == ReservationStatus.CANCELED){
            throw new IllegalStateException(newStatus.toString());
        }
        this.reservationStatus = newStatus;
    }
}
