package RIwi.BackendSpringboot.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import RIwi.BackendSpringboot.model.entities.RestrictionEntity;

@Repository

public interface RestrictionRepository extends JpaRepository<RestrictionEntity , Long> {

    
}
