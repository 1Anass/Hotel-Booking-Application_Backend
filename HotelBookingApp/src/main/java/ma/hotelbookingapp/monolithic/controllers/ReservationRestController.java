package ma.hotelbookingapp.monolithic.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ma.hotelbookingapp.monolithic.data.entities.Reservation;
import ma.hotelbookingapp.monolithic.data.entities.ReservationStatus;
import ma.hotelbookingapp.monolithic.data.repositories.UserRepository;
import ma.hotelbookingapp.monolithic.services.ReservationService;

@RestController
@RequestMapping("/rest/reservation")
public class ReservationRestController {
    
    @Autowired
    ReservationService reservationService;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/list")
    public List<Reservation> getReservationByGuest(@RequestHeader Authentication authentication){
        String username = authentication.getName();
        long userId = userRepository.findByUsername(username);
        return reservationService.getReservationsByGuest(userId);
    }
    
    @GetMapping("/checkout")
    public void checkout(@RequestHeader Authentication authentication){
        String username = authentication.getName();
        long userId = userRepository.findByUsername(username);
        reservationService.checkout(userId);
        return;
    }

    @GetMapping("/backOffice/list")
    public List<Reservation> getReservationByGuest(@RequestParam long guestId) {
        return reservationService.getReservationsByGuest(guestId);
    }

    @GetMapping("/update/reservationstatus")
    public void updateReservationStatus(@RequestParam long reservationId, @RequestParam int newStatus){
        switch(newStatus){
            case 1:
                reservationService.changeReservationStatus(reservationId, ReservationStatus.PENDING);
                break;
            case 2:
                reservationService.changeReservationStatus(reservationId, ReservationStatus.PAID);
                break;
            case 3:
                reservationService.changeReservationStatus(reservationId, ReservationStatus.USED);
                break;
            case 4:
                reservationService.changeReservationStatus(reservationId, ReservationStatus.CANCELED);
                break;
        }        
    }


}
