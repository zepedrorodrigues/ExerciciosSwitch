package org.example.Domain;

public class GPSLocation {

    private double latitude;
    private double longitude;
    public GPSLocation(double latitude, double longitude) throws Exception {
        if (latitude < -90 || latitude > 90) {
            throw new Exception("Invalid latitude");
        }
        if (longitude < -180 || longitude > 180) {
            throw new Exception("Invalid longitude");}
        this.latitude = latitude;
        this.longitude = longitude;}
}
