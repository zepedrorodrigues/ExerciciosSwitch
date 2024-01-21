package org.example.DTOs;

public class RoomDTO {
    private String roomId;
    private String name;

    private int floor;

    private double width;

    private double length;

    private double height;

    public RoomDTO(String roomId, String name, int floor, double width, double length, double height) {
        this.roomId = roomId;
        this.name = name;
        this.floor = floor;
        this.width = width;
        this.length = length;
        this.height = height;}

    public String getRoomId() {
        return roomId;}

    public String getName() {
        return name;}

    public int getFloor() {
        return floor;}

    public double getWidth() {
        return width;}

    public double getLength() {
        return length;}

    public double getHeight() {
        return height;}


}
