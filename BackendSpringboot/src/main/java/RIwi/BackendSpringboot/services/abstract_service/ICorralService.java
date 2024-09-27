package RIwi.BackendSpringboot.services.abstract_service;

import java.util.List;

import RIwi.BackendSpringboot.infraestructure.Adapter.Request.CorralRequest;
import RIwi.BackendSpringboot.infraestructure.Adapter.Response.AnimalsByCorralResponse;
import RIwi.BackendSpringboot.infraestructure.Adapter.Response.CorralResponse;

public interface ICorralService {

    public CorralResponse createCorral(CorralRequest corralRequest);
    public List<CorralResponse> getAllCorrals();
    public CorralResponse getCorralById(Long id);
    public AnimalsByCorralResponse getAnimalsByCorral(Long id);
}
