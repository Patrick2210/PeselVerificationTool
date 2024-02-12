package com.szaruga.peselverificationtool.service;

import com.szaruga.peselverificationtool.exception.ValidationException;
import com.szaruga.peselverificationtool.util.PeselValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.szaruga.peselverificationtool.constants.ApplicationConstants.PESEL_NUMBER_NOT_NULL;
/**
 * Service class for verifying PESEL numbers.
 */
@Service
public class NumberPeselService {
    private final PeselValidator peselValidator;
    /**
     * Constructs a new NumberPeselService with the provided PeselValidator.
     *
     * @param peselValidator The PeselValidator to use for validating PESEL numbers.
     */
    @Autowired
    public NumberPeselService(PeselValidator peselValidator) {
        this.peselValidator = peselValidator;
    }

    /**
     * Verifies if the provided PESEL number is valid.
     *
     * @param numberPesel The PESEL number to verify. Must not be null.
     * @return true if the provided PESEL number is valid, false otherwise.
     * @throws IllegalArgumentException If the provided PESEL number is null.
     * @throws ValidationException If the provided PESEL number is invalid according to validation rules.
     */
    public boolean verifyPesel(String numberPesel) {
        if (numberPesel == null) {
            throw new IllegalArgumentException(PESEL_NUMBER_NOT_NULL.getMessage());
        }
        try {
            peselValidator.validatePesel(numberPesel);
        } catch (IllegalArgumentException | ValidationException exception) {
            return false;
        }
        return true;
    }
}