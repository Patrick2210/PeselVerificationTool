package com.szaruga.peselverificationtool.service;

import com.szaruga.peselverificationtool.exception.ValidationException;
import com.szaruga.peselverificationtool.util.PeselValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NumberPeselService {
    private final PeselValidator peselValidator;
    @Autowired
    public NumberPeselService(PeselValidator peselValidator) {
        this.peselValidator = peselValidator;
    }

    /**
     * Verify pesel is valid
     *
     * @param numberPesel non-null pesel number
     * @return if pesel number is valid return true, otherwise false
     * @throws IllegalArgumentException when argument peselNumber is null
     */
    public boolean verifyPesel(String numberPesel) {
        if (numberPesel == null) {
            throw new IllegalArgumentException("peselNumber can not be null");
        }
        try {
            peselValidator.validatePesel(numberPesel);
        } catch (IllegalArgumentException | ValidationException exception) {
            return false;
        }
        return true;
    }
}