package org.example.Maps;

import org.example.Domain.GPSLocation;
import org.example.Domain.Location;
import org.example.Domain.SensorType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapsHouse {
    public Map<String, MapRooms> housetoRoom;
    public Map<String, Location> housetoLocation;
    public Map<Location, GPSLocation> locationGPSLocation;

    public Map<String, List<SensorType>> houseToSensorType;
    public MapsHouse(int houseId) {
        housetoRoom = new HashMap<>();
        housetoLocation = new HashMap<>();
        locationGPSLocation = new HashMap<>();}

    public boolean createHouse(String houseId, String address, String zipCode, double latitude, double longitude) {
        if (housetoLocation.containsKey(houseId))
            return false;
        housetoRoom.put(houseId, new MapRooms());
        try{Location location = new Location(address, zipCode);
            GPSLocation gpsLocation = new GPSLocation(latitude, longitude);
        housetoLocation.put(houseId, location);
        locationGPSLocation.put(location, gpsLocation);
        return true;}
        catch (Exception e) {return false;}}

    public boolean setAddress(String houseId, String address, String zipCode) {
        if (!housetoLocation.containsKey(houseId))
            return false;
        try{Location location = new Location(address, zipCode);
            housetoLocation.put(houseId, location);
            locationGPSLocation.put(location, locationGPSLocation.get(housetoLocation.get(houseId)));
            return true;}
        catch (Exception e) {return false;}}

    public boolean setGPSLocation(String houseId, double latitude, double longitude) {
        if (!housetoLocation.containsKey(houseId))
            return false;
        try{Location location = housetoLocation.get(houseId);
            GPSLocation gpsLocation = new GPSLocation(latitude, longitude);
            locationGPSLocation.put(location, gpsLocation);
            return true;}
        catch (Exception e) {return false;}}

    public boolean addSensorType(String houseId, String type, String unit) {
        if (!houseToSensorType.containsKey(houseId))
            return false;
        for(SensorType sensorType : houseToSensorType.get(houseId)){
            if(sensorType.getType()==type)
                return false;}
        try{houseToSensorType.get(houseId).add(new SensorType(type,unit));
            return true;}
        catch (Exception e) {return false;}}

    public SensorType getSensorTypeByName(String houseId, String name){
        List<SensorType> validSensorTypes = houseToSensorType.get(houseId);
        for(SensorType st : validSensorTypes){
            if(st.getType().equalsIgnoreCase(name))
                return st;}
        return null;}

}