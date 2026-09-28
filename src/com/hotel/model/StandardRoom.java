
package com.hotel.model;

public class StandardRoom extends Room implements IDiscountable {

    private int maxGuests;

    public StandardRoom() {
    }

    public StandardRoom(String id, String roomNumber,
                        double basePrice, int maxGuests) {
        super(id, roomNumber, basePrice);
        this.maxGuests = maxGuests;
    }

    @Override
    public double calculatePrice() {
        return basePrice - calculateDiscount();
    }

    @Override
    public double calculateDiscount() {
        // Low season discount: 10%
        return basePrice * 0.10;
    }

    public int getMaxGuests() {
        return maxGuests;
    }

    public void setMaxGuests(int maxGuests) {
        this.maxGuests = maxGuests;
    }

    @Override
    public String toString() {
        return "StandardRoom{" +
                "id='" + id + '\'' +
                ", roomNumber='" + roomNumber + '\'' +
                ", basePrice=" + basePrice +
                ", maxGuests=" + maxGuests +
                ", finalPrice=" + calculatePrice() +
                '}';
    }
}
