package com.kodilla.testing.weather.mock;

import com.kodilla.testing.weather.stub.Temperatures;
import com.kodilla.testing.weather.stub.WeatherForecast;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class WeatherForecastTestSuite {
    @Mock
    private Temperatures temperaturesMock;

    @BeforeEach
    void setUp() {
        when(temperaturesMock.getTemperatures()).thenReturn(Map.of("Rzeszow", 25.5, "Krakow", 26.2,
                "Wroclaw", 24.8, "Warszawa", 25.2, "Gdansk", 26.1));
    }

    @Test
    void testCalculateForecastWithMock() {

        //Given
        temperaturesMock.getTemperatures();
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);
        //When
        int quantityOfSensors = weatherForecast.calculateForecast().size();
        //Then
        Assertions.assertEquals(5, quantityOfSensors);
    }

    @Test
    void testCalculateAverageTemperatureWithMock() {

        //Given
        temperaturesMock.getTemperatures();
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);
        //When
        double averageTemperature = weatherForecast.calculateAverageTemperature();
        //Then
        Assertions.assertEquals(25.6, averageTemperature);
    }

    @Test
    void testCalculateMediumTemperatureWithMockOddCount() {

        //Given
        temperaturesMock.getTemperatures();
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);
        //When
        double mediumTemperature = weatherForecast.calculateMediumTemperature();
        //Then
        Assertions.assertEquals(25.5, mediumTemperature);
    }

    @Test
    void testCalculateMediumTemperatureWithMockEvenCount() {
        //Given
        Map<String, Double> temperaturesMapEvenCount = new HashMap<>();
        temperaturesMapEvenCount.put("Rzeszow", 25.5);
        temperaturesMapEvenCount.put("Krakow", 26.2);
        temperaturesMapEvenCount.put("Wroclaw", 24.8);
        temperaturesMapEvenCount.put("Warszawa", 25.2);
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMapEvenCount);
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);
        //When
        double mediumTemperature = weatherForecast.calculateMediumTemperature();
        //Then
        Assertions.assertEquals(25.3, mediumTemperature);
    }
}
