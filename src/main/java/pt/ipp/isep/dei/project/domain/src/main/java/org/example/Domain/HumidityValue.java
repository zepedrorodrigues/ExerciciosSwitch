package org.example.Domain;

public class HumidityValue implements Value{
    private double humidity;

    public HumidityValue(double temperature) {
        this.humidity = humidity;
    }

    @Override
    public String toValue() {
        return "" + humidity;
    }

    @Override
    public String toString() {
        return "HumidityValue{" + "Humidity=" + humidity + '}';
    }
}
