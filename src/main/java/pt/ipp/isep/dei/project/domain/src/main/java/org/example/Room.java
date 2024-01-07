package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a room in a Smart Home, which is a logical part of a house with specific functionalities.
 * A room has a name, house floor, and dimensions. It can be used to manage devices that act as sensors,
 * actuators, or both. Devices in a room have the same set of permissions, and the room may have a set of owners.
 */
public class Room {
    /**
     * The name of the room
     */
    private String name;

    /**
     * The floor of the room
     */
    private int floor;
    /**
     * The dimensions of the room
     */
    private Dimensions dimensions;

    /**
     * the list of devices
     */
    private List<Device> deviceList = new ArrayList<>();

    /**
     * Constructor for creating a Room instance with specified name, floor, and dimensions.
     *
     * @param name   the name of the room (must not be null or empty)
     * @param floor  the floor of the room
     * @param width  the width of the room (must be a non-negative value)
     * @param length the length of the room (must be a non-negative value)
     * @param height the height of the room
     * @throws IllegalArgumentException if input parameters are invalid
     */
    public Room(String name, int floor, double width, double length, double height) {
        this.name = name;
        this.floor = floor;
        this.dimensions = new Dimensions(width, length, height);
    }

    /**
     * Getter method to retrieve the name of the room.
     *
     * @return the name of the room
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter method to retrieve the floor of the room.
     *
     * @return the floor of the room
     */
    public int getFloor() {
        return this.floor;
    }

    /**
     * Getter method to retrieve the width of the room.
     *
     * @return the width of the room
     */
    public double getWidth() {
        return this.dimensions.getWidth();
    }

    /**
     * Getter method to retrieve the length of the room.
     *
     * @return the length of the room
     */
    public double getLength() {
        return this.dimensions.getLength();
    }

    /**
     * Getter method to retrieve the height of the room.
     *
     * @return the height of the room
     */
    public double getHeight() {
        return this.dimensions.getHeight();
    }

    /**
     * Method to add a device to room
     *
     * @param device the device to be added
     * @throws IllegalArgumentException if the device is invalid or already exists
     */
    public void addDevice(Device device) {
        for (Device devices : deviceList) {
            if (devices.getName().equals(device.getName()))
                throw new IllegalArgumentException("Device name already exists");}
        deviceList.add(device);
    }
}

