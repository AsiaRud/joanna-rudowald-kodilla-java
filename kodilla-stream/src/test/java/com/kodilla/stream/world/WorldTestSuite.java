package com.kodilla.stream.world;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorldTestSuite {

    @Test
    void testGetPeopleQuantity() {
        //Given
        Continent asia = new Continent("Asia");
        Continent europe = new Continent("Europe");
        Continent africa = new Continent("Africa");
        Continent southAmerica = new Continent("South America");

        asia.addCountry(new Country(new BigDecimal("1409670000"), "China"));
        asia.addCountry(new Country(new BigDecimal("1388163000"), "India"));
        asia.addCountry(new Country(new BigDecimal("29164578"), "Nepal"));

        europe.addCountry(new Country(new BigDecimal("47889958"), "Spain"));
        europe.addCountry(new Country(new BigDecimal("10656633"), "Sweden"));

        africa.addCountry(new Country(new BigDecimal("237527782"), "Nigeria"));
        africa.addCountry(new Country(new BigDecimal("70545865"), "Tanzania"));
        africa.addCountry(new Country(new BigDecimal("24074580"), "Burkina Faso"));

        southAmerica.addCountry(new Country(new BigDecimal("211998573"), "Brazil"));
        southAmerica.addCountry(new Country(new BigDecimal("28405543"), "Venezuela"));
        southAmerica.addCountry(new Country(new BigDecimal("45696159"), "Argentina"));
        southAmerica.addCountry(new Country(new BigDecimal("6929153"), "Paraguay"));

        World world = new World();
        world.addContinent(asia);
        world.addContinent(europe);
        world.addContinent(africa);
        world.addContinent(southAmerica);

        //When
        BigDecimal totalPopulation = world.getPeopleQuantity();

        //Then
        assertEquals("3510721824", totalPopulation.toString());

    }
}
