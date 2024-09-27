package RIwi.BackendSpringboot.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "Corral")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CorralEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;


    @Min(value = 1, message = "Capacity must be at least 1")
    @Column(nullable = false)
    private Integer capacity;
    
    @OneToMany(mappedBy = "corral", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AnimalEntity> animals;
}