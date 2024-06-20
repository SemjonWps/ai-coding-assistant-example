import { Injectable } from '@angular/core';
import { InMemoryDbService } from 'angular-in-memory-web-api';
import { Hero } from './hero';

@Injectable({
  providedIn: 'root',
})
export class InMemoryDataService implements InMemoryDbService {
  createDb() {
    const heroes = [
      { id: 12, name: 'Mickey Mouse', birthplace: 'Disneyland', height: 120, dateOfBirth: new Date(1928, 11, 18) },
      { id: 14, name: 'Donald Duck', birthplace: 'Duckburg', height: 100, dateOfBirth: new Date(1934, 6, 9) },
      { id: 15, name: 'Goofy', birthplace: 'Goofyville', height: 200, dateOfBirth: new Date(1932, 5, 25) },
      { id: 16, name: 'Minnie Mouse', birthplace: 'Disneyland', height: 110, dateOfBirth: new Date(1928, 11, 18) },
      { id: 17, name: 'Daisy Duck', birthplace: 'Duckburg', height: 95, dateOfBirth: new Date(1940, 6, 9) },
      { id: 18, name: 'Pluto', birthplace: 'Disneyland', height: 80, dateOfBirth: new Date(1930, 6, 1) },
      { id: 19, name: 'Simba', birthplace: 'Pride Rock', height: 150, dateOfBirth: new Date(1994, 6, 15) },
      { id: 20, name: 'Mulan', birthplace: 'China', height: 165, dateOfBirth: new Date(1998, 6, 19) }
    ];
    return {heroes};
  }

  // Overrides the genId method to ensure that a hero always has an id.
  // If the heroes array is empty,
  // the method below returns the initial number (11).
  // if the heroes array is not empty, the method below returns the highest
  // hero id + 1.
  genId(heroes: Hero[]): number {
    return heroes.length > 0 ? Math.max(...heroes.map(hero => hero.id)) + 1 : 11;
  }
}
