import { Place } from './Place';

export class Region extends Place {
  climate: string;
  majorCities: string[];

  constructor(name: string, description: string, climate: string, majorCities: string[]) {
    super(name, description);
    this.climate = climate;
    this.majorCities = majorCities;
  }

  getClimate(): string {
    return this.climate;
  }

  getMajorCities(): string[] {
    return this.majorCities;
  }
}