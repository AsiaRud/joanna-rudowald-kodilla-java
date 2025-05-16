package com.kodilla.stream.world;

import java.math.BigDecimal;

public final class Country {
    private final BigDecimal quantityOfPeople;
    private final String countryName;

    public Country(BigDecimal quantityOfPeople, String countryName) {
        this.quantityOfPeople = quantityOfPeople;
        this.countryName = countryName;
    }

    public BigDecimal getPeopleQuantity() {
        return quantityOfPeople;
    }

    public String getCountryName() {
        return countryName;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Country country)) return false;

        return countryName.equals(country.countryName);
    }

    @Override
    public int hashCode() {
        return countryName.hashCode();
    }
}
