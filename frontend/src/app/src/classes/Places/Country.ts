import { Place } from './Place';

export class Country extends Place {
    capital: string;
    currency: string;

    constructor(name: string, description: string, capital: string, currency: string) {
        super(name, description);
        this.capital = capital;
        this.currency = currency;
    }

    getCapital(): string {
        return this.capital;
    }

    getCurrency(): string {
        return this.currency;
    }
}