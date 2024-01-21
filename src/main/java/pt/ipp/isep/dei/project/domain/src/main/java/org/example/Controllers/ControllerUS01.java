package org.example.Controllers;

import org.example.DTOs.LocationDTO;
import org.example.Maps.MapsHouse;

public class ControllerUS01 {
    public ControllerUS01() {
        //Empty constructor, is a controller
    }
    public boolean defineLocation(String houseId, LocationDTO locationDTO, MapsHouse mapHouse){
        return (mapHouse.setAddress(houseId, locationDTO.getAddress(), locationDTO.getZipCode())&&
                mapHouse.setGPSLocation(houseId, locationDTO.getLatitude(), locationDTO.getLongitude()));}
}
