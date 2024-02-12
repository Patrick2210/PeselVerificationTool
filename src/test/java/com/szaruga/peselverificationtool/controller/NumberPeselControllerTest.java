package com.szaruga.peselverificationtool.controller;

import com.szaruga.peselverificationtool.service.NumberPeselService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
/**
 * Unit tests for {@link NumberPeselController}.
 */
public class NumberPeselControllerTest {
    @Mock
    private NumberPeselService numberPeselService;

    @InjectMocks
    private NumberPeselController numberPeselController;
    /**
     * Sets up the test environment before each test method.
     */
    @BeforeEach
    public void setUp() {
        numberPeselService = mock(NumberPeselService.class);
        numberPeselController = new NumberPeselController(numberPeselService);
    }
    /**
     * Test case to verify that the controller returns 200 OK when a valid PESEL number is provided.
     */
    @Test
    void verifyPeselNumber_ValidPesel_Returns200Ok() {
        // Arrange
        String validPesel = "85031412345";
        when(numberPeselService.verifyPesel(validPesel)).thenReturn(true);

        // Act
        ResponseEntity<Void> response = numberPeselController.verifyPeselNumber(validPesel);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(numberPeselService, times(1)).verifyPesel(validPesel);
    }
    /**
     * Test case to verify that the controller returns 400 Bad Request when an invalid PESEL number is provided.
     */
    @Test
    void verifyPeselNumber_InvalidPesel_Returns400BadRequest() {
        // Arrange
        String invalidPesel = "ABC123";
        when(numberPeselService.verifyPesel(invalidPesel)).thenReturn(false);

        // Act
        ResponseEntity<Void> response = numberPeselController.verifyPeselNumber(invalidPesel);

        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        verify(numberPeselService, times(1)).verifyPesel(invalidPesel);
    }
}