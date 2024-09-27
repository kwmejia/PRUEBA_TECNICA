package RIwi.BackendSpringboot.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import RIwi.BackendSpringboot.infraestructure.Adapter.Request.AnimalRequest;
import RIwi.BackendSpringboot.infraestructure.Adapter.Response.AnimalResponse;
import RIwi.BackendSpringboot.services.services.AnimalService;

import java.util.List;

@RestController
@RequestMapping("/api/animals")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @PostMapping
    public ResponseEntity<AnimalResponse> createAnimal(@RequestBody AnimalRequest animalRequest) {
        AnimalResponse animalResponse = animalService.createAnimal(animalRequest);
        return new ResponseEntity<>(animalResponse, HttpStatus.CREATED);
    }

    @GetMapping("/corrals/{corralId}")
    public ResponseEntity<List<AnimalResponse>> getAnimalsByCorral(@PathVariable Long corralId) {
        List<AnimalResponse> responseDTOs = animalService.getAnimalsByCorral(corralId);
        return new ResponseEntity<>(responseDTOs, HttpStatus.OK);
    }

    @GetMapping("/high-risk")
    public ResponseEntity<List<AnimalResponse>> getHighRiskAnimals() {
        List<AnimalResponse> responseDTOs = animalService.getHighRiskAnimals();
        return new ResponseEntity<>(responseDTOs, HttpStatus.OK);
    }

    @GetMapping("/average-age/{corralId}")
    public ResponseEntity<Double> getAverageAgeByCorral(@PathVariable Long corralId) {
        double averageAge = animalService.getAverageAgeByCorral(corralId);
        return new ResponseEntity<>(averageAge, HttpStatus.OK);
    }


}
