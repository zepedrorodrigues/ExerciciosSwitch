package org.example.Controllers;

import org.example.DTOs.RoomDTO;
import org.example.Maps.MapRooms;
import org.example.Maps.MapsHouse;

public class ControllerUC02 {
    public ControllerUC02() {
        //Empty constructor, is a controller
    }

    public boolean addRoom(String houseId, RoomDTO roomDTO, MapsHouse mapHouse, MapRooms mapRooms) {
        if(!mapHouse.housetoRoom.containsKey(houseId)) return false;
        return mapRooms.createRoom(roomDTO.getRoomId(), roomDTO.getName(), roomDTO.getFloor(), roomDTO.getWidth(), roomDTO.getLength(), roomDTO.getHeight());
    }
}
