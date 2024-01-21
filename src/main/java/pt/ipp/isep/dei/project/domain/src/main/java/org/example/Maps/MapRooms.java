package org.example.Maps;

import org.example.Domain.Dimensions;


import java.util.HashMap;
import java.util.Map;

public class MapRooms {

    public Map<String, Integer> roomToFlooor;
    public Map<String, String> roomToName;
    public Map<String, Dimensions> roomToDimensions;
    public Map<String, MapDevices> roomToDevices;
    public MapRooms() {
        roomToFlooor = new HashMap<>();
        roomToName = new HashMap<>();
        roomToDimensions = new HashMap<>();
        roomToDevices = new HashMap<>();}

    public boolean createRoom(String roomId, String name, int floor, double width, double length, double height) {
        if (roomToName.containsKey(roomId))
            return false;
        try{Dimensions dimensions = new Dimensions(width, length, height);
            roomToFlooor.put(roomId, floor);
            roomToName.put(roomId, name);
            roomToDimensions.put(roomId, dimensions);
            roomToDevices.put(roomId, new MapDevices());
            return true;}
        catch (Exception e) {return false;}}

}
