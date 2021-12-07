package ma.hotelbookingapp.monolithic.data.dtos;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Hashtable;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Iterator;
import java.util.List;

import ma.hotelbookingapp.monolithic.data.entities.Discount;
import ma.hotelbookingapp.monolithic.data.entities.Room;


public class StayPlan implements Serializable{

    private long id;
    private Date startDate;
    private Date endDate;
    private Hashtable<Room, Long> selectedRooms;
    
    public StayPlan(){ }

    public StayPlan(long id, Date startDate, Date endDate){
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        selectedRooms = new Hashtable<Room,Long>();
    }  
/*
    public List<Room> getSelectedRooms(){
        List<Room> rooms = new LinkedList<Room>();

    }
*/
    public void addRoom(Room room, Date startDate, Date endDate){
        
        selectedRooms.put(room, room.getId());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
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

    public Hashtable<Room, Long> getSelectedRooms() {
        return this.selectedRooms;
    }

    public void setSelectedRooms(Hashtable<Room, Long> selectedRooms) {
        this.selectedRooms = selectedRooms;
    }

    public void removeRoom(Room room){
        if(room != null)
            selectedRooms.remove(room);
    }

    public float computeTotalPrice(List<Discount> discounts){
        Iterator<Entry<Room,Long>> iterator = selectedRooms.entrySet().iterator();
        float totalPrice = 0;
		while (iterator.hasNext()) {
            Entry<Room, Long> e = iterator.next();
            totalPrice += e.getKey().getPrice();
		}
        for(Discount discount : discounts){
            totalPrice -= totalPrice * discount.getReductionPercentage();
        }
        return totalPrice;
    }

    public void empty(){
        this.selectedRooms.clear();
    }

    public boolean isEmpty(){
        if (this.selectedRooms.size() != 0){
            return false;
        }
        else
            return true;
    }
}
