package org.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * GPSLocationTest is a test class for GPSLocation.
 * It uses JUnit to test the functionality of GPSLocation methods.
 */
class GPSLocationTest {
    /**
     * test constructor with valid parameters
     */
    @Test
    void testConstructorValidParameters() {
        //Arrange and Act
        GPSLocation gpsLocation = new GPSLocation(1, 2);
        //Assert
        assertEquals(1, gpsLocation.getLatitude());
        assertEquals(2, gpsLocation.getLongitude());
    }

    /**
     * test constructor with invalid negative parameters
     */
    @Test
    void testConstructorInvalidParametersNegativeLatitudeAndLongitude() {
        //Arrange and Act
        Exception exc = assertThrows(IllegalArgumentException.class, () -> new GPSLocation(-91, -181));
        //Assert
        assertEquals("Invalid GPS Location", exc.getMessage());
    }

    /**
     * test constructor with invalid positive parameters
     */
    @Test
    void testConstructorInvalidParametersPositiveLatitudeAndLongitude() {
        //Arrange and Act
        Exception exc = assertThrows(IllegalArgumentException.class, () -> new GPSLocation(91, 181));
        //Assert
        assertEquals("Invalid GPS Location", exc.getMessage());
    }

    /**
     * test constructor with valid parameters in the negative boundary
     */
    @Test
    void testConstructorvalidParemetersBoundaryNegativeLatitudeAndLongitude() {
        //Arrange and Act
        GPSLocation gpsLocation = new GPSLocation(-90, -180);
        //Assert
        assertEquals(-90, gpsLocation.getLatitude());
        assertEquals(-180, gpsLocation.getLongitude());
    }

    /**
     * test constructor with valid parameters in the positive boundary
     */
    @Test
    void testConstructorvalidParemetersBoundaryPositiveLatitudeAndLongitude() {
        //Arrange and Act
        GPSLocation gpsLocation = new GPSLocation(90, 180);
        //Assert
        assertEquals(90, gpsLocation.getLatitude());
        assertEquals(180, gpsLocation.getLongitude());
    }

    /**
     * test getLatitude() method
     */
    @Test
    void testGetLatitude() {
        //Arrange and Act
        GPSLocation gpsLocation = new GPSLocation(1, 2);
        //Assert
        assertEquals(1, gpsLocation.getLatitude());
    }

    /**
     * test getLongitude() method
     */
    @Test
    void testGetLongitude() {
        //Arrange and Act
        GPSLocation gpsLocation = new GPSLocation(1, 2);
        //Assert
        assertEquals(2, gpsLocation.getLongitude());
    }
}