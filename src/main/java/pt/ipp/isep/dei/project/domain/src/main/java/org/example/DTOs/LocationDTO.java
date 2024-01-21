package org.example.DTOs;

public class LocationDTO {

    private String address;
    private String zipCode;
    private double latitude;
    private double longitude;

    public LocationDTO(String address, String zipCode, double latitude, double longitude) {
        this.address = address;
        this.zipCode = zipCode;
        this.latitude = latitude;
        this.longitude = longitude;}

    public String getAddress() {
        return address;}

    public String getZipCode() {
        return zipCode;}

    public double getLatitude() {
        return latitude;}

    public double getLongitude() {
        return longitude;}
}
