package org.example;

/**
 * Represents the location of a house.
 * The location includes the address, zip code, and GPS location.
 */
public class Location {
    /**the address of the house (Street, Number, Door)
     */
    private String address;
    /**the zip code of the house
     */
    private String zipCode;
    /**GPS location of the house
     */
    private String gpsLocation;

    /**
     * Constructor
     *
     * @param address the address of the house (Street, Number, Door)
     * @param zipCode the zip code of the house
     * @param gpsLocation the GPS location of the house
     */
    public Location(String address, String zipCode, String gpsLocation) {
        this.address = address;
        this.zipCode = zipCode;
        this.gpsLocation = gpsLocation;
    }
}
