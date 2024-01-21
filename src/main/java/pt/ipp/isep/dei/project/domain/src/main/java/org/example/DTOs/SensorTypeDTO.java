package org.example.DTOs;

public class SensorTypeDTO {
    private String type;
    private String unit;
    public SensorTypeDTO(String type, String unit){
        this.type = type;
        this.unit = unit;}

    public String getType(){
        return type;}

    public String getUnit(){
        return unit;}
}
