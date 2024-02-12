package com.szaruga.peselverificationtool.service;

import com.szaruga.peselverificationtool.exception.ValidationException;
import com.szaruga.peselverificationtool.util.PeselValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for {@link NumberPeselService}.
 */
public class NumberPeselServiceTest {
    private NumberPeselService numberPeselService;

    /**
     * Sets up the test environment before each test method.
     */
    @BeforeEach
    public void setUp() {
        PeselValidator peselValidator = new PeselValidator();
        numberPeselService = new NumberPeselService(peselValidator);
    }

    /**
     * Test verifyPesel()
     *
     * @throws IllegalArgumentException when null input is provided.
     */
    @Test
    public void testVerifyPesel_NullInput_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> numberPeselService.verifyPesel(null));
    }

    /**
     * Test verifyPesel() returns false when an invalid PESEL number is provided.
     */
    @Test
    public void testVerifyPesel_InvalidPesel_ReturnsFalse() {
        assertFalse(numberPeselService.verifyPesel("ABC123"));
    }

    /**
     * Test verifyPesel() returns true when a valid PESEL number is provided.
     */
    @Test
    public void testVerifyPesel_ValidPesel_ReturnsTrue() {
        String validPesel = "85031412345";
        assertTrue(numberPeselService.verifyPesel(validPesel));
    }

    /**
     * Test that verifyPesel() returns true when a valid PESEL number is provided.
     */
    @Test
    public void testVerifyPesel_ValidationException_ReturnsFalse() {
        PeselValidator mockPeselValidator = new PeselValidator() {
            @Override
            public void validatePesel(String numberPesel) {
                throw new ValidationException("Validation failed");
            }
        };
        NumberPeselService serviceWithMock = new NumberPeselService(mockPeselValidator);
        assertFalse(serviceWithMock.verifyPesel("85031412345"));
    }
}