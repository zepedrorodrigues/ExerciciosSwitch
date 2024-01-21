package org.example.Domain;

public class TemperatureSensor implements Sensor {
    private String name;
    private TemperatureValue value;
    private SensorType type;


    public TemperatureSensor(String name, SensorType type) {
        this.name = name;
        this.type = type;
    }
    public void setValue(double temperature) {
        this.value = new TemperatureValue(temperature);
    }
    public Value getValue() {
        return value;
    }

    public String getName() {
        return name;
    }


    public SensorType getType() {
        return type;
    }

}

