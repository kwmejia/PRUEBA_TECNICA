import {
  IsString,
  IsNumber,
  Min,
} from 'class-validator';

export class CreateAnimalDto {
  @IsString()
  name: string;

  @IsNumber()
  @Min(0)
  age: number;

  @IsNumber()
  corralId: number;
}