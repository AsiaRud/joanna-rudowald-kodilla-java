package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public final class World {

    private final Set<Continent> continents= new HashSet<>();

    public void addContinent(Continent continent) {
        continents.add(continent);
    }

    public BigDecimal getPeopleQuantity(){
        return continents.stream()
                .flatMap(continent -> continent.getCountries().stream())
                .map(Country::getPeopleQuantity)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }



    public Set<Continent> getContinents() {
        return continents;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof World world)) return false;

        return continents.equals(world.continents);
    }

    @Override
    public int hashCode() {
        return continents.hashCode();
    }
}
