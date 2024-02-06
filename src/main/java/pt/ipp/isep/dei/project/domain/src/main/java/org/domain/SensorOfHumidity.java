package org.domain;

/**
 * This class represents a humidity sensor.
 * It implements the Sensor interface and has a name and a type.
 */

public class SensorOfHumidity implements Sensor {
    private String name;
    private String type = "Humidity";


    public SensorOfHumidity() {}
    /**
     * Constructs a new SensorOfHumidity with the given name and type.
     *
     * @param name the name of the sensor
     */

    public SensorOfHumidity(String name) {
        this.name = name;
    }

    /**
     * Returns the name of the sensor.
     *
     * @return the name of the sensor
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the type of the sensor.
     *
     * @return the type of the sensor
     */

    public String getType() {
        return type;
    }
}