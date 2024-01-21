package org.example.Domain;

public class TemperatureValue implements Value{
    private double temperature;

    public TemperatureValue(double temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toValue() {
        return "" + temperature;
    }

    @Override
    public String toString() {
        return "TemperatureValue{" +
                "temperature=" + temperature +
                '}';
    }
}

