package ma.hotelbookingapp.monolithic.data.repositories;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ma.hotelbookingapp.monolithic.data.entities.ServiceType;

@RepositoryRestResource
public interface ServiceTypeRepository extends BaseRepository<ServiceType>{
    
}
