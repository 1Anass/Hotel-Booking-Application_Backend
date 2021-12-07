package ma.hotelbookingapp.monolithic.data.repositories;

import org.springframework.data.jpa.repository.Query;

import ma.hotelbookingapp.monolithic.data.entities.User_;

public interface UserRepository extends BaseRepository<User_>{

    User_ findById(long userId);

    @Query(value = "select u.id from User u where u.username = %?1%", nativeQuery = true)
    Long findByUsername(String username);
    
    @Query(value = "select u from User u where u.username = %?1%", nativeQuery = true)
    User_ findUserByUsername(String username);
}
