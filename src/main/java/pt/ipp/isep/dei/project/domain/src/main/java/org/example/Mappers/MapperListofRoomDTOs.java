package org.example.Mappers;

import org.example.DTOs.RoomDTO;
import org.example.Maps.MapRooms;

import java.util.ArrayList;
import java.util.List;

public class MapperListofRoomDTOs {

    public MapperListofRoomDTOs() {
        //Empty constructor, is a Mapper
    }

    public List<RoomDTO> transformIntoDTO(MapRooms mapRooms){
        List<RoomDTO> rooms = new ArrayList<>();
        for(int i = 0; i<mapRooms.roomToName.size();i++){
            String roomId = (String) mapRooms.roomToName.keySet().toArray()[i];
            String name = mapRooms.roomToName.get(roomId);
            int floor =  mapRooms.roomToFlooor.get(roomId);
            double width = mapRooms.roomToDimensions.get(roomId).getWidth();
            double length = mapRooms.roomToDimensions.get(roomId).getLength();
            double height = mapRooms.roomToDimensions.get(roomId).getHeight();
            rooms.add(new RoomDTO(roomId,name,floor,width,length,height));}
        return rooms;}
}
