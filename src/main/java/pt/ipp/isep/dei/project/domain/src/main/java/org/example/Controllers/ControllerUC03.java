package org.example.Controllers;

import org.example.DTOs.RoomDTO;
import org.example.Mappers.MapperListofRoomDTOs;
import org.example.Maps.MapRooms;
import org.example.Maps.MapsHouse;

import java.util.List;

public class ControllerUC03 {

    public ControllerUC03() {
        //Empty constructor, is a Controller
    }

    public List<RoomDTO> getRoomList(String houseId, MapsHouse mapsHouse){
    if(!mapsHouse.housetoRoom.containsKey(houseId)||mapsHouse==null||houseId==null)
            throw new IllegalArgumentException("House not found");
        MapRooms mapRooms = mapsHouse.housetoRoom.get(houseId);
        return new MapperListofRoomDTOs().transformIntoDTO(mapRooms);

    }
}
