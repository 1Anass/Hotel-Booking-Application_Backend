package ma.hotelbookingapp.monolithic.data.repositories;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ma.hotelbookingapp.monolithic.data.entities.Review;

@RepositoryRestResource

public interface ReviewRepository extends BaseRepository<Review>{

    
}
