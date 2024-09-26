package RIwi.BackendSpringboot.model.repositories;

import RIwi.BackendSpringboot.model.entities.AnimalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimalRepository extends JpaRepository<AnimalEntity,Integer> {
    List<AnimalEntity> findAllById(Iterable<Integer> ids);
    List<AnimalEntity> findByCorralId(Long corralId);
    List<AnimalEntity> findByDangerous(boolean dangerous);
}
