import { Place } from './Place';

export class City extends Place {
    population: number;
    area: number;

    constructor(name: string, description: string, population: number, area: number) {
        super(name, description);
        this.population = population;
        this.area = area;
    }

    getPopulationDensity(): number {
        return this.population / this.area;
    }
}