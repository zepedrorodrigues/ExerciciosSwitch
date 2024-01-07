package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * A house may include gardens and other outbuildings that are part of the house (e.g. garage, garden
 * shed, etc.). It may also have more than one floor. A house has an address, including ZIP code, and a
 * GPS location.
 */
public class House {

    /**
     * Location of the house
     */
    private Location location;

    private List<Room> roomList = new ArrayList<>();

    /**
     * Constructor for the house
     *
     * @param address     the address of the house
     * @param zipCode     the zip code of the house
     * @param gpsLocation the GPS location of the house
     * @throws InstantiationException if the address, zipCode or gpsLocation is null or empty
     */
    public House(String address, String zipCode, String gpsLocation) throws InstantiationException {
        if (!validLocationArguments(address, zipCode, gpsLocation))
            throw new InstantiationException("Invalid Address, ZipCode or GPS Location");
        this.location = new Location(address, zipCode, gpsLocation);
    }

    /**
     * Validates the arguments for the constructor
     *
     * @param address     the address of the house
     * @param zipCode     the zip code of the house
     * @param gpsLocation the GPS location of the house
     * @return true if the arguments are valid, false otherwise
     */
    private boolean validLocationArguments(String address, String zipCode, String gpsLocation) {
        return address != null && !address.isEmpty() && zipCode != null && !zipCode.isEmpty() && gpsLocation != null && !gpsLocation.isEmpty();
    }

    /**
     * Configures the location of the house
     *
     * @param newAddress     the new address of the house
     * @param newZipCode     the new zip code of the house
     * @param newGPSLocation the new GPS location of the house
     * @return true if the location was successfully configured, false otherwise
     * @throws InstantiationException if the address, zipCode or gpsLocation is null or empty
     */
    public boolean configLocation(String newAddress, String newZipCode, String newGPSLocation) throws InstantiationException {
        if (validLocationArguments(newAddress, newZipCode, newGPSLocation)) {
            this.location = new Location(newAddress, newZipCode, newGPSLocation);
            return true;
        } else {
            throw new InstantiationException("Invalid Address, ZipCode or GPS Location");
        }
    }

    /**
     * Method to add a room to the house.
     *
     * @param name   the name of the room
     * @param floor  the floor of the room
     * @param width  the width of the room
     * @param length the length of the room
     * @param height the height of the room
     * @throws IllegalArgumentException if the room is null or if a room with the same name already exists
     */
    public void addRoom(String name, int floor, double width, double length, double height) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Room name cannot be null or empty.");
        }
        if (width <= 0 || length <= 0 || height < 0) {
            throw new IllegalArgumentException("Invalid dimensions");
        }
        for (Room existingRoom : roomList) {
            if (existingRoom.getName().equals(name)) {
                throw new IllegalArgumentException("A room with this name already exists");
            }
        }
        Room room = new Room(name, floor, width, length, height);
        this.roomList.add(room);
    }

    /**
     * Returns a copy of the list of rooms in the house.
     * This method does not return the original list. Any modifications made to the returned list will not affect the original list.
     *
     * @return a copy of the list of rooms in the house
     */
    public List<Room> getRoomList() {
        List<Room> roomListCopy = new ArrayList<>();
        for (Room room : this.roomList)
            roomListCopy.add(new Room(room.getName(), room.getFloor(), room.getLength(), room.getWidth(), room.getHeight()));
        return roomListCopy;
    }

    /**
     * Adds a device to a room in the house.
     *
     * @param name    the name of the device
     * @param type the type of the device
     * @param sens the list of sensors of the device
     * @param acts the list of actuators of the device
     * @param roomName the name of the room to which the device will be added
     * @throws IllegalArgumentException if the device or room is null or if the room is not in the house
     */
    public void addDeviceToRoom(String name, String type, List<Sensor> sens, List<Actuator> acts, String roomName) {
        if (roomName == null || roomName.isEmpty()) {
            throw new IllegalArgumentException("Invalid room name");}
        try {
            Device myDevice = new Device(name, type, sens, acts);
            boolean roomFound = false;
            for (Room room : roomList) {
                if (room.getName().equals(roomName)) {
                    room.addDevice(myDevice);
                    roomFound = true;
                    break;}}
            if (!roomFound) {
                throw new IllegalArgumentException("Room not found");}
        } catch (IllegalArgumentException | NullPointerException e) {
            throw new IllegalArgumentException(e.getMessage());}}}