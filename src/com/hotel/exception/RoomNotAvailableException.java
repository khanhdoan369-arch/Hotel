package com.hotel.exception;

/**
 * Thrown when a room is already booked.
 */
public class RoomNotAvailableException extends BaseHotelException {

    public RoomNotAvailableException(String message) {
        super(message);
    }

}