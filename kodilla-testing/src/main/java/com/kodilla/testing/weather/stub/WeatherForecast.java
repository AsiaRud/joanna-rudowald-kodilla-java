package com.kodilla.testing.weather.stub;

import java.util.*;

public class WeatherForecast {
    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();
        for (Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()) {
            // adding 1 celsius degree to current value
            // as a temporary weather forecast
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0);
        }
        return resultMap;
    }

    public double calculateAverageTemperature() {
        Map<String, Double> temperaturesMap = temperatures.getTemperatures();
        double sum = 0;
        for (double temperature : temperaturesMap.values()) {
            sum += temperature;
        }
        return Math.round((sum / temperaturesMap.size())*10)/10.0;
    }

    public double calculateMediumTemperature() {
        List<Double> temperaturesValuesList = new ArrayList<>(temperatures.getTemperatures().values());
        double[] temperaturesValuesArray = temperaturesValuesList.stream().mapToDouble(Double::doubleValue).toArray();
        Arrays.sort(temperaturesValuesArray);

        if(temperaturesValuesArray.length % 2 == 0) {
            return Math.floor(((temperaturesValuesArray[(temperaturesValuesArray.length / 2)-1]+temperaturesValuesArray[temperaturesValuesArray.length/2])/2)*10)/10.0;
        }
        else{
            return Math.round((temperaturesValuesArray[(int)Math.floor(temperaturesValuesArray.length/2)])*10)/10.0;
        }

    }
}
