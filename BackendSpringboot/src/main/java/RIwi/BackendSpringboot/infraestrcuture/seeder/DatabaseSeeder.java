package RIwi.BackendSpringboot.infraestrcuture.seeder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import RIwi.BackendSpringboot.model.entities.CorralEntity;
import RIwi.BackendSpringboot.model.repositories.CorralRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Component
@AllArgsConstructor

@Slf4j
public class DatabaseSeeder  implements CommandLineRunner {

    @Autowired
    private CorralRepository corralRepository;

    @Override
    public void run(String... args) throws Exception {
        
        if (this.corralRepository.count() > 0) return;


        CorralEntity corral1 = CorralEntity.builder().name("Corral 1").capacity(10).build();
        CorralEntity corral2 = CorralEntity.builder().name("Corral 2").capacity(20).build();
        CorralEntity corral3 = CorralEntity.builder().name("Corral 3").capacity(30).build();


        this.corralRepository.save(corral1);
        this.corralRepository.save(corral2);
        this.corralRepository.save(corral3);
        log.info("Corral created successfully");
    }



}
