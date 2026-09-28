package com.hotel.exception;

/**
 * Thrown when login credentials are invalid.
 */
public class InvalidCredentialsException extends BaseHotelException {

    public InvalidCredentialsException(String message) {
        super(message);
    }

}
