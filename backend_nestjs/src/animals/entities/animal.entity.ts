import { Corral } from 'src/corrals/entities/corral.entity';
import {
  Entity,
  Column,
  PrimaryGeneratedColumn,
  ManyToOne
} from 'typeorm';

@Entity()
export class Animal {
  @PrimaryGeneratedColumn()
  id: number;

  @Column()
  name: string;

  @Column()
  age: number;

  
  @ManyToOne(() => Corral, (corral) => corral.animals)
  corral: Corral;
}