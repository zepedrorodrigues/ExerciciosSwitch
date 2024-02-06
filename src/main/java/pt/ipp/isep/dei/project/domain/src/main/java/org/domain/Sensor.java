package org.domain;

/**
 * This interface represents a generic sensor.
 * It has methods to get the type and name of the sensor.
 */

public interface Sensor {
    /**
     * Returns the type of the sensor.
     *
     * @return the type of the sensor
     */
    String getType();

    /**
     * Returns the name of the sensor.
     *
     * @return the name of the sensor
     */
    String getName();
}

