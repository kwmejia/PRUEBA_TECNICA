package RIwi.BackendSpringboot.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import RIwi.BackendSpringboot.model.entities.CorralEntity;


@Repository
public interface CorralRepository extends JpaRepository<CorralEntity, Long> {

}
