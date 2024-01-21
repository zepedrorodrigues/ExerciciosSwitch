package org.example.Controllers;

import org.example.DTOs.RoomDTO;
import org.example.Maps.MapRooms;
import org.example.Maps.MapsHouse;

public class ControllerUS02 {
    public ControllerUS02() {
        //Empty constructor, is a controller
    }

    public boolean addRoom(String houseId, RoomDTO roomDTO, MapsHouse mapHouse, MapRooms mapRooms) {
        if(!mapHouse.housetoRoom.containsKey(houseId))
            return false;
        String roomId = roomDTO.getRoomId();
        String name = roomDTO.getName();
        int floor = roomDTO.getFloor();
        double width = roomDTO.getWidth();
        double length = roomDTO.getLength();
        double height = roomDTO.getHeight();
        return mapRooms.createRoom(roomId, name, floor, width, length, height);

    }
}
