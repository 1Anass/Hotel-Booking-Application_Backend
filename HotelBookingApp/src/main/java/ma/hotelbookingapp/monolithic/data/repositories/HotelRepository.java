package ma.hotelbookingapp.monolithic.data.repositories;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.List;

//import ma.hotelbookingapp.monolithic.data.dtos.Hotel;
import ma.hotelbookingapp.monolithic.data.entities.Hotel;
import ma.hotelbookingapp.monolithic.data.entities.Room;

@RepositoryRestResource
public interface HotelRepository extends BaseRepository<Hotel> {

    Hotel findById(long id);

    List<Hotel> findByHotelName(String hotelName);

    List<Hotel> findByCity(String city);

    @Query(value = "select h.id from hotel h where h.distanceFromCenter - %?1% = 2 and h.starsRating = %?2%", nativeQuery = true)
    List<Long> findSimilarHotels(float distanceFromCenter, int starsRating);

    /*@Query(value = "select h.room from HotelDTO
 h where h.Id = %?1%", nativeQuery = true)
    List<Room> findRoomsOfHotel(long hotelId);*/
}
