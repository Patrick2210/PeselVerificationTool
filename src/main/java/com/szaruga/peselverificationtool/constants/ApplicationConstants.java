package com.szaruga.peselverificationtool.constants;

public enum ApplicationConstants {

    MUST_BE_NOT_NULL("must be not null"),
    MUST_BE_NOT_EMPTY("must be not empty"),
    PESEL_NUMBER_LENGTH(" length is 11 dig number "),
    PESEL_NUMBER_INCORRECT("Pesel number incorrect"),
    SPECIAL_CHARACTERS("must contain only whole numbers,letters and special characters not allowed");

    private final String message;

    ApplicationConstants(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
