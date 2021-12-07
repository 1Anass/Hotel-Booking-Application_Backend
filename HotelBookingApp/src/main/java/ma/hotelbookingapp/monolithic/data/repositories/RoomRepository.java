package ma.hotelbookingapp.monolithic.data.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import ma.hotelbookingapp.monolithic.data.entities.Room;

@CrossOrigin(origins = "*")
@RepositoryRestResource
public interface RoomRepository extends BaseRepository<Room>{

    //@Query("select r from room")
    List<Room> findAll();

    @Query(value="select r from room r where r.maxNumberOfGuests = %?4% and r.hotel.city = %?3% and %?1% > r.reservation.reservations.endDate and %?2%Date > r.reservation.reservations.endDate",nativeQuery =true)
    List<Room> findByPeriodAndCityAndMaxNumberOfGuests(Date startDate, Date endDate, String city, int maxNumberOfGuests);
    
    Room findById(long roomId);

    @Query(value = "select r from room r where r.distanceFromCenter - %?1% = 2 and r.surface - %?2% = 5 and r.starsRating = %?3%", nativeQuery = true)
    List<Room> findSimilarRooms(float distanceFromCenter, float roomSurface, int starsRating);

    @Query(value = "select r.price from room r where r.roomId = %?1%", nativeQuery = true)
    List<Float> findPricesByRoom(long roomId);

    @Query(value = "select r from Room r where r.hotelId = %?1%", nativeQuery = true)
    List<Room> findRoomsOfHotel(long hotelId);
}
