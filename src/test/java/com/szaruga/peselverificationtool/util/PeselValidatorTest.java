package com.szaruga.peselverificationtool.util;

import com.szaruga.peselverificationtool.exception.ValidationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PeselValidatorTest {

    private PeselValidator peselValidator;

    @BeforeEach
    public void setUp() {
        peselValidator = new PeselValidator();
    }

    @Test
    public void testValidatePesel_NullInput_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> peselValidator.validatePesel(null));
    }

    @Test
    public void testValidatePesel_EmptyInput_ThrowsValidationException() {
        assertThrows(ValidationException.class, () -> peselValidator.validatePesel(""));
    }

    @Test
    public void testValidatePesel_InvalidInput_ThrowsValidationException() {
        assertThrows(ValidationException.class, () -> peselValidator.validatePesel("ABC%123"));
    }

    @Test
    public void testValidatePesel_IncorrectLength_ThrowsValidationException() {
        assertThrows(ValidationException.class, () -> peselValidator.validatePesel("1234567890"));
    }

    @Test
    public void testValidatePesel_CorrectPesel_ValidatesSuccessfully() {
        String validPesel = "85031412345";
        peselValidator.validatePesel(validPesel);
    }
}
