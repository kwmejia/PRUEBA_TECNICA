package RIwi.BackendSpringboot.infraestructure.Adapter.Request;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnimalRequest {
    @NotNull
    private String name;
    @Min(0)
    private int age;
    @NotNull
    private Boolean dangerous;
    @NotNull
    private Long corralId;
    private Long incompatibleAnimalId;
}
