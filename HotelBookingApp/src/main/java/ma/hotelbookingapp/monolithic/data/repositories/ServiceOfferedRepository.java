package ma.hotelbookingapp.monolithic.data.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ma.hotelbookingapp.monolithic.data.entities.ServiceOffered;

@RepositoryRestResource
public interface ServiceOfferedRepository extends BaseRepository<ServiceOffered> {
    
    @Query(value = "select from serviceoffered s where s.room.roomNumber = %?1% and s.room.floorNumber = %?2% and s.room.buildingNumber = %?3%", nativeQuery = true)
    List<ServiceOffered> findByRoomId(int roomNumber, int floorNumber, int buildingNumber);
}
