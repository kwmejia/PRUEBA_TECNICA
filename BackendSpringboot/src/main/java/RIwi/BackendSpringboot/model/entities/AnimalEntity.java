package RIwi.BackendSpringboot.model.entities;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity(name = "Animal")
public class AnimalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Name cannot be null")
    @NotEmpty(message = "Name cannot be empty")
    private String name;

    @Min(value = 0, message = "Age cannot be negative")
    private int age;

    @NotNull(message = "'dangerous' field cannot be null")
    private boolean dangerous;

    @ManyToMany
    @JoinTable(
            name = "animal_restriction",
            joinColumns = @JoinColumn(name = "animal_id"),
            inverseJoinColumns = @JoinColumn(name = "restricted_animal_id")
    )
    private List<AnimalEntity> incompatibleAnimals = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "corral_id")
    private CorralEntity corral;

}
