package ma.hotelbookingapp.monolithic.data.repositories;

import org.springframework.data.jpa.repository.Query;
import java.util.List;

import ma.hotelbookingapp.monolithic.data.entities.Reservation;


public interface ReservationRepository extends BaseRepository<Reservation>{
    
    //@Query("select r from Reservation where r.user.userId = userId")
    List <Reservation> findByUser(long userId);

    Reservation findById(long id);

}
