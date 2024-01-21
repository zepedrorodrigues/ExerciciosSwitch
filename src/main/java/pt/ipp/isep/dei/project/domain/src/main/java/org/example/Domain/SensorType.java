package org.example.Domain;


public class SensorType {
    private String type;
    private String unit;

    public SensorType(String type, String unit){
        this.type = type;
        this.unit = unit;}
    public String getType(){
        return type;}
    public String getUnit(){
        return unit;}
}