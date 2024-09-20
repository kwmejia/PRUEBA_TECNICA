package RIwi.BackendSpringboot.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "corral")
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

    private Integer capacity;
}
