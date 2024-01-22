package org.example.DTOs;

import java.util.List;

public class DeviceDTOfunc {
    private String deviceId;
    private List<String> functionalities;
    private String location;

    public DeviceDTOfunc(String deviceId, List<String> functionalities, String location){
        this.deviceId = deviceId;
        this.functionalities = functionalities;
        this.location = location;}

    public String getDeviceId(){return deviceId;}

    public List<String> getFunctionalities(){return functionalities;}

    public String getLocation(){return location;}
}
