package DTOs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * LocationDTO is a Data Transfer Object class for Location.
 * It is used to transfer data between processes.
 */
class LocationDTOTest {
    /**
     * Test method for LocationDTO.getAddress().
     * It verifies that the method returns the correct address of the location.
     */
    @Test
    void testGetAddress() {
        //Arrange
        LocationDTO locationDTO = new LocationDTO("address", "zipCode", 1, 1);
        //Act
        String address = locationDTO.getAddress();
        //Assert
        assertEquals("address", address);
    }

    /**
     * Test method for LocationDTO.getZipCode().
     * It verifies that the method returns the correct zip code of the location.
     */
    @Test
    void testGetZipCode() {
        //Arrange
        LocationDTO locationDTO = new LocationDTO("address", "zipCode", 1, 1);
        //Act
        String zipCode = locationDTO.getZipCode();
        //Assert
        assertEquals("zipCode", zipCode);
    }

    /**
     * Test method for LocationDTO.getLatitude().
     * It verifies that the method returns the correct latitude of the location.
     */
    @Test
    void testGetLatitude() {
        //Arrange
        LocationDTO locationDTO = new LocationDTO("address", "zipCode", 1, 1);
        //Act
        double latitude = locationDTO.getLatitude();
        //Assert
        assertEquals(1, latitude);
    }

    /**
     * Test method for LocationDTO.getLongitude().
     * It verifies that the method returns the correct longitude of the location.
     */
    @Test
    void testGetLongitude() {
        //Arrange
        LocationDTO locationDTO = new LocationDTO("address", "zipCode", 1, 1);
        //Act
        double longitude = locationDTO.getLongitude();
        //Assert
        assertEquals(1, longitude);
    }
}