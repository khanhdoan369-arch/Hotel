package com.hotel.exception;

/**
 * Thrown when a booking ID already exists.
 */
public class DuplicateBookingException extends BaseHotelException {

    public DuplicateBookingException(String message) {
        super(message);
    }

}
