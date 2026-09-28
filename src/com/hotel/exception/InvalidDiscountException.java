package com.hotel.exception;

/**
 * Thrown when a discount code is invalid.
 */
public class InvalidDiscountException extends BaseHotelException {

    public InvalidDiscountException(String message) {
        super(message);
    }

}
