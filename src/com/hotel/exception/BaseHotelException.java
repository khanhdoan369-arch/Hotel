package com.hotel.exception;

public class BaseHotelException extends Exception {

    public BaseHotelException(String message) {
        super(message);
    }

    public BaseHotelException(String message, Throwable cause) {
        super(message, cause);
    }

}