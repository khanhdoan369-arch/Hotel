package com.hotel.exception;

/**
 * Thrown when user does not have permission.
 */
public class AccessDeniedException extends BaseHotelException {

    public AccessDeniedException(String message) {
        super(message);
    }

}