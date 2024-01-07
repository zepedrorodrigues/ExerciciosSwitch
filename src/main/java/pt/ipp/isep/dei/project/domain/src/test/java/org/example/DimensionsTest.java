package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DimensionsTest {
    @Test
    void testConstructorValid() {
        // Arrange
        double expectedWidth = 10.0;
        double expectedLength = 20.0;
        double expectedHeight = 30.0;

        // Act
        Dimensions dimensions = new Dimensions(expectedWidth, expectedLength, expectedHeight);

        // Assert
        assertEquals(expectedWidth, dimensions.getWidth());
        assertEquals(expectedLength, dimensions.getLength());
        assertEquals(expectedHeight, dimensions.getHeight());
    }
}