import { Corral } from 'src/corrals/entities/corral.entity';
import { Restriction } from 'src/restriction/entities/restriction.entity';
import {
  Entity,
  Column,
  PrimaryGeneratedColumn,
  ManyToOne,
  OneToMany
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

  @OneToMany(() => Restriction, (restriction) => restriction.animal)
  restrictions: Restriction[];
}