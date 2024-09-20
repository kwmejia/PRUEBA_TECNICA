import { Animal } from 'src/animals/entities/animal.entity';
import {
  Entity,
  Column,
  PrimaryGeneratedColumn,
  OneToMany
} from 'typeorm';

@Entity()
export class Corral {
  @PrimaryGeneratedColumn()
  id: number;

  @Column()
  name: string;

  @Column()
  capacity: number;


  @OneToMany(() => Animal, (animal) => animal.corral)
  animals: Animal[];
}