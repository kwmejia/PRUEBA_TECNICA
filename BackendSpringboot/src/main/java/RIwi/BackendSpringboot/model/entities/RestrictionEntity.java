package RIwi.BackendSpringboot.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Restriction")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RestrictionEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "animal_id")
    private AnimalEntity animal;

    @ManyToOne
    @JoinColumn(name = "animal_restricted_id")
    private AnimalEntity animalRestringido;
}
