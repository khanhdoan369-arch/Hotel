
package com.hotel.model;

public abstract class Room {

    protected String id;
    protected String roomNumber;
    protected double basePrice;

    public Room() {
    }

    public Room(String id, String roomNumber, double basePrice) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.basePrice = basePrice;
    }

    public abstract double calculatePrice();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id='" + id + '\'' +
                ", roomNumber='" + roomNumber + '\'' +
                ", basePrice=" + basePrice +
                '}';
    }
}
