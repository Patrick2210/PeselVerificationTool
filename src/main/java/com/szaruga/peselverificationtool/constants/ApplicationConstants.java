package com.szaruga.peselverificationtool.constants;
/**
 * Enumeration of application constants containing error messages.
 */
public enum ApplicationConstants {

    MUST_BE_NOT_NULL("must be not null"),
    MUST_BE_NOT_EMPTY("must be not empty"),
    PESEL_NUMBER_LENGTH(" length is 11 dig number "),
    PESEL_NUMBER_INCORRECT("pesel number incorrect"),
    PESEL_NUMBER_NOT_NULL("pesel number can not be null"),
    SPECIAL_CHARACTERS("must contain only whole numbers,letters and special characters not allowed");

    private final String message;
    /**
     * Constructs an ApplicationConstants enum with the provided error message.
     *
     * @param message The error message associated with the constant.
     */
    ApplicationConstants(String message) {
        this.message = message;
    }
    /**
     * Gets the error message associated with the constant.
     *
     * @return The error message.
     */
    public String getMessage() {
        return message;
    }
}
