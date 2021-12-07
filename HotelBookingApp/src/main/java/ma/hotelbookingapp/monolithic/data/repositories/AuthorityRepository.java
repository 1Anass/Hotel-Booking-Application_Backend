package ma.hotelbookingapp.monolithic.data.repositories;

import java.util.List;

import ma.hotelbookingapp.monolithic.data.entities.Authority;

public interface AuthorityRepository extends BaseRepository<Authority> {
    List<Authority> findByAuthority(String authority);
}