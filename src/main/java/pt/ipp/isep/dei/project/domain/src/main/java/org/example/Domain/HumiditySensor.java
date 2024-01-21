package org.example.Domain;

public class HumiditySensor implements Sensor {

    private HumidityValue value;
    private SensorType type;
    private String name;

    public HumiditySensor(String name, SensorType type) {
        this.name = name;
        this.type = type;
    }
    public void setValue(double humidity) {
        this.value = new HumidityValue(humidity);
    }

    public String getName() {
        return name;
    }

    public Value getValue() {
        return value;
    }

    public SensorType getType() {
        return type;
    }
}