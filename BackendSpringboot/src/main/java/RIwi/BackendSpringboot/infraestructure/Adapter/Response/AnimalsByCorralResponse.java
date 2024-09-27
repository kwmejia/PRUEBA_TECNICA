package RIwi.BackendSpringboot.infraestructure.Adapter.Response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class AnimalsByCorralResponse extends CorralResponse {

    private List<AnimalResponse> animals;
}
