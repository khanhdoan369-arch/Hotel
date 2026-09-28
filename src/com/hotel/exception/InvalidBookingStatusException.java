package com.hotel.exception;

/**
 * Thrown when a booking status is invalid.
 */
public class InvalidBookingStatusException extends BaseHotelException {

    public InvalidBookingStatusException(String message) {
        super(message);
    }

}
