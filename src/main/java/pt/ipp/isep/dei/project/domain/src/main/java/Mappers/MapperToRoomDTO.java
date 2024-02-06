package Mappers;

import DTOs.RoomDTO;
import org.domain.Room;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is a Mapper for RoomDTO.
 * It is used to map a list of rooms to a list of RoomDTO objects.
 */
public class MapperToRoomDTO {
    /**
     * Constructs a new MapperToRoomDTO.
     */
    public MapperToRoomDTO() {
        // Empty constructor,as it Is a Mapper (used for its methods only)
    }

    /**
     * Converts a list of rooms to a list of RoomDTO objects.
     *
     * @param roomList the list of rooms to be converted.
     * @return the list of RoomDTOs.
     */
    public List<RoomDTO> getRoomList(List<Room> roomList) {
        List<RoomDTO> rooms = new ArrayList<>(); // Create a new list each time
        for (Room room : roomList) {
            RoomDTO myRoomDTO = roomToDTO(room);
            rooms.add(myRoomDTO);
        }
        return rooms;
    }

    /**
     * Converts a room to a RoomDTO object.
     *
     * @param room the room to be converted.
     * @return the RoomDTO.
     */
    private RoomDTO roomToDTO(Room room) {
        return new RoomDTO(room.getName(), room.getFloor(), room.getDimensions().getWidth(), room.getDimensions().getLength(), room.getDimensions().getHeight());
    }
}
