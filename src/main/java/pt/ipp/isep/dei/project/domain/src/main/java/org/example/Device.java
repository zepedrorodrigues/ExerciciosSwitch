package org.example;

import java.util.List;
import java.util.ArrayList;

/**
 * Represents a device that contains sensors and actuators.
 * This class models a device by its name, and lists of sensors and actuators.
 * It includes functionality to create deep copies of these lists to ensure
 * that changes in the copies do not affect the original lists.
 */
public class Device {

    /**
     * The name of the device.
     */
    private String name;

    /**
     * The type of the device.
     */
    private String type;
    /**
     * The list of sensors attached to the device.
     */
    private List<Sensor> sensors;

    /**
     * The list of actuators attached to the device.
     */
    private List<Actuator> actuators;

    /**
     * Constructs a new Device with the specified name, list of sensors, and list of actuators.
     * It creates deep copies of the sensor and actuator lists.
     *
     * @param name the name of the device - > can not be Empty or null!
     * @param sens the list of sensorTypes to be attached to the device
     * @param acts the list of actuatorTypes to be attached to the device -> can't be null!
     * @throws NullPointerException     if the name, sensor list or actuator list is null
     * @throws IllegalArgumentException if the name is empty or the sensor list is empty
     */
    public Device(String name, String type, List<Sensor> sens, List<Actuator> acts) {
        if (name == null || sens == null || acts == null || type == null)
            throw new NullPointerException("Null value not valid");
        if (name.isEmpty())
            throw new IllegalArgumentException("Invalid device name");
        if (type.isEmpty())
            throw new IllegalArgumentException("Invalid device type");
        if (sens.isEmpty())
            throw new IllegalArgumentException("Invalid or empty sensor list");
        this.name = name;
        this.type = type;
        this.sensors = deepCopyListSensors(sens);
        this.actuators = deepCopyListActuators(acts);
    }

    /**
     * deepCopy of the Sensors to ensure not shallow copy of Sensors
     * checks if the SensorType is valid, if not, it is not added to the list
     *
     * @param list of SensorTypes to be non-shallow copied
     * @return a deepCopy of the list
     */
    private List<Sensor> deepCopyListSensors(List<Sensor> list) {
        List<Sensor> copy = new ArrayList<>();
        for (Sensor element : list)
            copy.add(new Sensor(element.getName(), element.getType()));
        return copy;
    }

    /**
     * deepCopy of the Actuators to ensure not shallow copy of Actuators
     * checks if the Actuator is valid, if not, it is not added to the list
     *
     * @param list of Actuators to be non-shallow copied
     * @return a deepCopy of the list
     */
    private List<Actuator> deepCopyListActuators(List<Actuator> list) {
        List<Actuator> copy = new ArrayList<>();
        for (Actuator element : list)
            copy.add(new Actuator(element.getName(), element.getCharacteristics()));
        return copy;
    }

    /**
     * Getter method to retrieve the name of the device.
     *
     * @return the name of the device
     */
    public String getName() {
        return this.name;
    }
}

