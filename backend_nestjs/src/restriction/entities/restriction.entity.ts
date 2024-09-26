import { Animal } from 'src/animals/entities/animal.entity';
import {
  Entity,

  PrimaryGeneratedColumn,
  ManyToOne,
  JoinColumn
} from 'typeorm';

@Entity()
export class Restriction {
  @PrimaryGeneratedColumn()
  id: number;

  @ManyToOne(() => Animal, (animal) =>  animal.restrictions)
  @JoinColumn({name: "animal_id"})
  animal: Animal;

  @ManyToOne(() => Animal, (animal) =>  animal.restrictions)
  @JoinColumn({name: "animal_restricted_id"})
  animalRestrictedId: Animal;

}