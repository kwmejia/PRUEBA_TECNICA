package RIwi.BackendSpringboot.services.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import RIwi.BackendSpringboot.infraestructure.Adapter.Request.CorralRequest;
import RIwi.BackendSpringboot.infraestructure.Adapter.Response.AnimalsByCorralResponse;
import RIwi.BackendSpringboot.infraestructure.Adapter.Response.CorralResponse;
import RIwi.BackendSpringboot.model.entities.AnimalEntity;
import RIwi.BackendSpringboot.model.entities.CorralEntity;
import RIwi.BackendSpringboot.model.repositories.CorralRepository;
import RIwi.BackendSpringboot.services.abstract_service.ICorralService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class CorralService implements ICorralService {
    
    @Autowired
    private CorralRepository corralRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CorralResponse createCorral(CorralRequest corralRequest) {
        
        
        CorralEntity corral = new CorralEntity();
        corral.setName(corralRequest.getName());
        corral.setCapacity(corralRequest.getCapacity());
        CorralEntity savedCorral = corralRepository.save(corral);
        return modelMapper.map(savedCorral, CorralResponse.class);
    }


    @Override
    public CorralResponse getCorralById(Long id) {
        
        CorralEntity corral = corralRepository.findById(id).orElseThrow();
        return modelMapper.map(corral, CorralResponse.class);
    }

    @Override
    public List<CorralResponse> getAllCorrals() {
        List<CorralEntity> corrals = corralRepository.findAll();
        return corrals.stream()
                .map(corral -> modelMapper.map(corral, CorralResponse.class))
                .collect(Collectors.toList());  
    }


    @Override
    public AnimalsByCorralResponse getAnimalsByCorral(Long id) {
        CorralEntity corral = corralRepository.findById(id).orElseThrow();
        List<AnimalEntity> animals = corral.getAnimals();

        if (animals.isEmpty()) {
            throw new RuntimeException("El corral no tiene animales.");
        }
        return modelMapper.map(animals, AnimalsByCorralResponse.class);
    }

}
