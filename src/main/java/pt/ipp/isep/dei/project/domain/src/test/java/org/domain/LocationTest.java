package org.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
/**
 * This class contains test cases for the Location class.
 * Each test case corresponds to a different scenario of creating a Location instance.
 */
class LocationTest {
    /**
     * Test case for creating a new Location with valid parameters.
     * The test is supposed to be true if the Location is created with the correct address, zip code, latitude, and longitude.
     */
    @Test
    void testContructorValidParameters() {
        //Arrange
        String address = "Address";
        String zipCode = "ZipCode";
        double latitude = 1;
        double longitude = 1;
        // Act
        Location location = new Location(address, zipCode, latitude, longitude);
        //Assert
        assertEquals(address, location.getAddress());
        assertEquals(zipCode, location.getZipCode());
        assertEquals(latitude, location.getGpsLocation().getLatitude());
        assertEquals(longitude, location.getGpsLocation().getLongitude());
    }

    /**
     * Test case for the Location constructor with an empty address.
     * The test is supposed to throw an IllegalArgumentException.
     */
    @Test
    void testConstructorInvalidParametersEmptyAddress() {
        //Arrange
        String address = "";
        String zipCode = "ZipCode";
        double latitude = 1;
        double longitude = 1;
        // Act
        Exception exc = assertThrows(IllegalArgumentException.class, () -> new Location(address, zipCode, latitude, longitude));
        //Assert
        assertEquals("Invalid Address or ZipCode", exc.getMessage());
    }

    /**
     * Test case for the Location constructor with an empty zip code.
     * The test is supposed to throw an IllegalArgumentException.
     */
    @Test
    void testConstructorInvalidParametersEmptyZipCode() {
        //Arrange
        String address = "Address";
        String zipCode = "";
        double latitude = 1;
        double longitude = 1;
        // Act
        Exception exc = assertThrows(IllegalArgumentException.class, () -> new Location(address, zipCode, latitude, longitude));
        //Assert
        assertEquals("Invalid Address or ZipCode", exc.getMessage());
    }

    /**
     * Test case for the Location constructor with an invalid GPS location.
     * The test is supposed to throw an IllegalArgumentException.
     */
    @Test
    void testConstructorInvalidParametersInvalidGPSLocation() {
        //Arrange
        String address = "Address";
        String zipCode = "ZipCode";
        double latitude = 91;
        double longitude = 180;
        // Act
        Exception exc = assertThrows(IllegalArgumentException.class, () -> new Location(address, zipCode, latitude, longitude));
        //Assert
        assertEquals("Invalid GPS Location", exc.getMessage());
    }
}
