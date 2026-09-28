package com.hotel.exception;

/**
 * Base checked exception for hotel domain errors.
 */
public class BaseHotelException extends Exception {

    public BaseHotelException(String message) {
        super(message);
    }

    public BaseHotelException(String message, Throwable cause) {
        super(message, cause);
    }

}