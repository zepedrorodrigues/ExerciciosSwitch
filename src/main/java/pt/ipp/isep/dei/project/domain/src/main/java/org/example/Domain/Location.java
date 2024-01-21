package org.example.Domain;

import org.example.Domain.GPSLocation;

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


    /**
     * Constructor
     *
     * @param address the address of the house (Street, Number, Door)
     * @param zipCode the zip code of the house*/
    public Location(String address, String zipCode) {
        if(address.isEmpty()||zipCode.isEmpty())
            throw new IllegalArgumentException("Address and zip code must not be empty");
        this.address = address;
        this.zipCode = zipCode;
    }
}
