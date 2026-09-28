package com.hotel.exception;

/**
 * Thrown when a room ID already exists.
 */
public class DuplicateRoomException extends BaseHotelException {

    public DuplicateRoomException(String message) {
        super(message);
    }

}
