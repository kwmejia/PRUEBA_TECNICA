package RIwi.BackendSpringboot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import RIwi.BackendSpringboot.infraestructure.Adapter.Request.CorralRequest;
import RIwi.BackendSpringboot.infraestructure.Adapter.Response.AnimalsByCorralResponse;
import RIwi.BackendSpringboot.infraestructure.Adapter.Response.CorralResponse;
import RIwi.BackendSpringboot.services.abstract_service.ICorralService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/corrals")
public class CorralController {

    @Autowired
    private ICorralService corralService;

    @PostMapping
    public ResponseEntity<CorralResponse> createCorral(@RequestBody CorralRequest entity) {
        CorralResponse corralResponse = corralService.createCorral(entity);
        return new ResponseEntity<>(corralResponse, HttpStatus.CREATED);

    }
    @GetMapping("/{id}")
    public ResponseEntity<CorralResponse> getCorralById(@PathVariable Long id) {
        CorralResponse corralResponse = corralService.getCorralById(id);
        return new ResponseEntity<>(corralResponse, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<CorralResponse>> getAllCorrals() {
        List<CorralResponse> corralResponses = corralService.getAllCorrals();
        return new ResponseEntity<>(corralResponses, HttpStatus.OK);
    }

    @GetMapping("/{id}/animals")
    public ResponseEntity<AnimalsByCorralResponse> getAnimalsByCorral(@PathVariable Long id) {
        AnimalsByCorralResponse animalsByCorralResponse = corralService.getAnimalsByCorral(id);
        return new ResponseEntity<>(animalsByCorralResponse, HttpStatus.OK);
    }
    
    }
