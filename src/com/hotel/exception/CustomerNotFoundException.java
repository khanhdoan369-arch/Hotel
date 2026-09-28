package com.hotel.exception;

/**
 * Thrown when a customer cannot be found.
 */
public class CustomerNotFoundException extends BaseHotelException {

    public CustomerNotFoundException(String message) {
        super(message);
    }

}
