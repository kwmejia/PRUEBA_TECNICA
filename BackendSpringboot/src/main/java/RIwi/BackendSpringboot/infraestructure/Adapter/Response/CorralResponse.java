package RIwi.BackendSpringboot.infraestructure.Adapter.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class CorralResponse {
    private Long id;
    private String name;
    private int capacity;
}
