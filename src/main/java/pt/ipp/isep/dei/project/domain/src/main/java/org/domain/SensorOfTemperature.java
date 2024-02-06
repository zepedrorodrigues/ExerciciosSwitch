package org.domain;

/**
 * This class represents a temperature sensor.
 * It implements the Sensor interface and has a name and a type.
 */

public class SensorOfTemperature implements Sensor {
    /**
     * The name of the sensor.
     */
    private String name;

    /**
     * The type of the sensor, which is set to "Temperature" by default.
     */
    private String type = "Temperature";


    public SensorOfTemperature() {}
    /**
     * Constructs a new SensorOfTemperature with the given name and type.
     *
     * @param name the name of the sensor
     */

    public SensorOfTemperature(String name) {
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
