import { Module } from '@nestjs/common';
import { AnimalsService } from './animals.service';
import { AnimalsController } from './animals.controller';
import { TypeOrmModule } from '@nestjs/typeorm';
import { Animal } from './entities/animal.entity';
import { Corral } from 'src/corrals/entities/corral.entity';
import { Restriction } from 'src/restriction/entities/restriction.entity';

@Module({
  imports: [
    TypeOrmModule.forFeature([Animal, Corral, Restriction]), // Asegúrate de que Animal esté aquí
  ],
  controllers: [AnimalsController],
  providers: [AnimalsService],
})
export class AnimalsModule {}
