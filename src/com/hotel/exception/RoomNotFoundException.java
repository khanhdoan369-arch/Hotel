package com.hotel.exception;

/**
 * Thrown when a room cannot be found.
 */
public class RoomNotFoundException extends BaseHotelException {

    public RoomNotFoundException(String message) {
        super(message);
    }

}