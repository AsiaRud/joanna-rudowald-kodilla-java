package com.kodilla.stream.world;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public final class Continent {

    private final Set<Country> countries = new HashSet<>();
    private final String continentName;

    public Continent(String continentName) {
        this.continentName = continentName;
    }

    public void addCountry(Country country) {
        countries.add(country);
    }

    public Set<Country> getCountries() {
        return countries;
    }

    public String getContinentName() {
        return continentName;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Continent continent)) return false;

        return countries.equals(continent.countries) && Objects.equals(continentName, continent.continentName);
    }

    @Override
    public int hashCode() {
        int result = countries.hashCode();
        result = 31 * result + Objects.hashCode(continentName);
        return result;
    }
}
