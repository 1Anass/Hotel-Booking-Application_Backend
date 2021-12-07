package ma.hotelbookingapp.monolithic.data.repositories;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ma.hotelbookingapp.monolithic.data.entities.Discount;

@RepositoryRestResource
public interface DiscountRepository extends BaseRepository<Discount> {
    
}
