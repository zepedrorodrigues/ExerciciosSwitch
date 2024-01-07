package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class LocationTest {
    @Test
    void newLocationWithValidArguments() {
        // Arrange & Act
        Location location = new Location("address", "zipCode", "gpsLocation");
        // Assert
        assertNotNull(location);
    }
}