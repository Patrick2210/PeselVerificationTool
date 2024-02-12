package com.szaruga.peselverificationtool.util;

import com.szaruga.peselverificationtool.exception.ValidationException;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

import static com.szaruga.peselverificationtool.constants.ApplicationConstants.*;

@Component
public class PeselValidator {
    /**
     * Validates a PESEL number.
     *
     * @param numberPesel The PESEL number to validate. Must not be null.
     * @throws IllegalArgumentException If the provided PESEL number is null.
     * @throws ValidationException If the provided PESEL number is not valid according to validation rules.
     */
    public void validatePesel(String numberPesel) {
        checkNotNull(numberPesel);
        checkNotEmpty(numberPesel);
        checkIfContainsOnlyWholeNumber(numberPesel);
        checkLength(numberPesel);
    }

    /**
     * Checks if the provided PESEL number is not null.
     *
     * @param numberPesel The PESEL number to check.
     * @throws IllegalArgumentException If the provided PESEL number is null.
     */
    private void checkNotNull(String numberPesel) {
        if (numberPesel == null) {
            throw new IllegalArgumentException(MUST_BE_NOT_NULL.getMessage());
        }
    }
    /**
     * Validate number pesel
     *
     * @param numberPesel
     * @throws ValidationException when number pesel equals empty
     */
    private void checkNotEmpty(String numberPesel) {
        if (numberPesel.isEmpty()) {
            throw new ValidationException(MUST_BE_NOT_EMPTY.getMessage());
        }
    }

    /**
     * Checks if the provided PESEL number is not empty.
     *
     * @param peselNumber The PESEL number to check.
     * @throws ValidationException If the provided PESEL number is empty.
     */
    private void checkLength(String peselNumber) {
        if (peselNumber.length() != 11) {
            throw new ValidationException(PESEL_NUMBER_LENGTH.getMessage());
        }
    }

    /**
     * Checks if the provided PESEL number has a valid length.
     *
     * @param peselNumber The PESEL number to check.
     * @throws ValidationException If the provided PESEL number has an invalid length.
     */
    private void checkIfContainsOnlyWholeNumber(String peselNumber) {
        if (!peselNumber.matches("^[0-9]+$")) {
            throw new ValidationException(SPECIAL_CHARACTERS.getMessage());
        }
    }
    /**
     * Checks if the provided PESEL number represents a date in the past.
     *
     * @param peselNumber The PESEL number to check.
     * @return The validated PESEL number if the date is in the past.
     * @throws ValidationException If the provided PESEL number represents a future date.
     */
    private String checkDateInPast(String peselNumber) {
        String yearStr = peselNumber.substring(0, 2);
        String monthStr = peselNumber.substring(2, 4);
        String dayStr = peselNumber.substring(4, 6);

        int year = Integer.parseInt(yearStr);
        int month = Integer.parseInt(monthStr);
        int day = Integer.parseInt(dayStr);

        if (month >= 1 && month <= 12) {
            year += 1900;
        }
        if (month >= 21 && month <= 32) {
            year += 2000;
            month -= 20;
        }
        if (month >= 41 && month <= 52) {
            year += 2100;
            month -= 40;
        }

        try {
            LocalDate birthDate = LocalDate.of(year, month, day);
            LocalDate today = LocalDate.now();
            if (birthDate.isBefore(today)) {
                return peselNumber;
            } else {
                throw new ValidationException(PESEL_NUMBER_INCORRECT.getMessage());
            }
        } catch (Exception e) {
            throw new ValidationException(PESEL_NUMBER_INCORRECT.getMessage());
        }
    }
}