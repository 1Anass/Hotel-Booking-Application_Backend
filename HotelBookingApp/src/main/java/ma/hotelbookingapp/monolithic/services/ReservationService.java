package ma.hotelbookingapp.monolithic.services;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.hotelbookingapp.monolithic.data.entities.Discount;
import ma.hotelbookingapp.monolithic.data.entities.Hotel;
import ma.hotelbookingapp.monolithic.data.dtos.StayPlan;
import ma.hotelbookingapp.monolithic.data.entities.Reservation;
import ma.hotelbookingapp.monolithic.data.entities.ReservationStatus;
import ma.hotelbookingapp.monolithic.data.entities.Room;
import ma.hotelbookingapp.monolithic.data.entities.User_;
import ma.hotelbookingapp.monolithic.data.repositories.HotelRepository;
import ma.hotelbookingapp.monolithic.data.repositories.ReservationRepository;
import ma.hotelbookingapp.monolithic.data.repositories.RoomRepository;
import ma.hotelbookingapp.monolithic.data.repositories.UserRepository;

@Service
public class ReservationService {
    
    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private HotelRepository hotelRepository;


    @Autowired
    private StayPlanService stayPlanService;

    

    public List<Reservation> getReservationsByGuest(long guestId){
        return reservationRepository.findByUser(guestId);
    }

    public void checkout(long userId){

        StayPlan stayPlan = stayPlanService.getStayPlan(userId);

        Set<Room> rooms = stayPlan.getSelectedRooms().keySet();

        List<Hotel> hotels = new LinkedList<Hotel>();

        for(Room room : rooms){
            hotels.add(room.getHotel());
        }

        List<Discount> discounts = new LinkedList<Discount>();

        for(Hotel hotel : hotels){
            discounts.addAll(hotel.getDiscounts());
        }



        if(stayPlan == null || stayPlan.computeTotalPrice(discounts) == 0)
            return;
        
        User_ user = userRepository.findById(userId);
        Reservation reservation = new Reservation(stayPlan, user);
        reservationRepository.save(reservation);
        stayPlanService.empty(stayPlan, user.getId());
    }

    public void changeReservationStatus(long orderId, ReservationStatus reservationStatus){
        Reservation reservation = reservationRepository.findById(orderId);
        reservation.updateStatus(reservationStatus);
        reservationRepository.save(reservation);
    }

}
