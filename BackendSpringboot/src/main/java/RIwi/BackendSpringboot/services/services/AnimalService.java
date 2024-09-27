package RIwi.BackendSpringboot.services.services;
import RIwi.BackendSpringboot.infraestructure.Adapter.Request.AnimalRequest;
import RIwi.BackendSpringboot.infraestructure.Adapter.Response.AnimalResponse;
import RIwi.BackendSpringboot.model.entities.AnimalEntity;
import RIwi.BackendSpringboot.model.entities.CorralEntity;
import RIwi.BackendSpringboot.model.repositories.AnimalRepository;
import RIwi.BackendSpringboot.model.repositories.CorralRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private CorralRepository corralRepository;

    @Autowired
    private ModelMapper modelMapper;

    public AnimalResponse createAnimal(AnimalRequest animalRequest) {
        AnimalEntity incompatibleAnimal = null;
        if (animalRequest.getIncompatibleAnimalId() != 0) { // Asumiendo que 0 es un valor inválido o no especificado
            incompatibleAnimal = animalRepository.findById(animalRequest.getIncompatibleAnimalId())
                    .orElseThrow(() -> new IllegalArgumentException("Animal incompatible no encontrado con ID: "
                            + animalRequest.getIncompatibleAnimalId()));
        }
        AnimalEntity animal = new AnimalEntity();
        animal.setName(animalRequest.getName());
        animal.setAge(animalRequest.getAge());
        animal.setDangerous(animalRequest.getDangerous());

        if (incompatibleAnimal != null) {
            animal.setIncompatibleAnimals(Collections.singletonList(incompatibleAnimal));
        }
        CorralEntity corral = corralRepository.findById(animalRequest.getCorralId())
                .orElseThrow(() -> new IllegalArgumentException("Corral no encontrado con ID: " + animalRequest.getCorralId()));

        if (corral.getAnimals().size() >= corral.getCapacity()) {
            throw new IllegalStateException("El corral está lleno.");
        }
        for (AnimalEntity existingAnimal : corral.getAnimals()) {
            if (incompatibleAnimal != null && incompatibleAnimal.equals(existingAnimal)) {
                throw new IllegalStateException("El nuevo animal es incompatible con los animales en el corral.");
            }
        }
        animal.setCorral(corral);
        AnimalEntity savedAnimal = animalRepository.save(animal);
        corral.getAnimals().add(savedAnimal);
        corralRepository.save(corral);
        return modelMapper.map(savedAnimal, AnimalResponse.class);
    }

    public List<AnimalResponse> getAnimalsByCorral(Long corralId) {
        List<AnimalEntity> animals = animalRepository.findByCorralId(corralId);
        return animals.stream()
                .map(animal -> modelMapper.map(animal, AnimalResponse.class))
                .collect(Collectors.toList());
    }

    public List<AnimalResponse> getHighRiskAnimals() {
        List<AnimalEntity> animals = animalRepository.findByDangerous(true);
        return animals.stream()
                .map(animal -> modelMapper.map(animal, AnimalResponse.class))
                .collect(Collectors.toList());
    }

    public double getAverageAgeByCorral(Long corralId) {
        List<AnimalEntity> animals = animalRepository.findByCorralId(corralId);
        return animals.stream()
                .mapToInt(AnimalEntity::getAge)
                .average()
                .orElse(0.0);
    }



}