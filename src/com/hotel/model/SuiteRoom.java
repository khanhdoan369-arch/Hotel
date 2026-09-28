package com.hotel.model;

public class SuiteRoom extends Room {

    private boolean hasJacuzzi;
    private double extraServiceFee;

    public SuiteRoom() {
    }

    public SuiteRoom(String id, String roomNumber,
                     double basePrice,
                     boolean hasJacuzzi,
                     double extraServiceFee) {

        super(id, roomNumber, basePrice);
        this.hasJacuzzi = hasJacuzzi;
        this.extraServiceFee = extraServiceFee;
    }

    @Override
    public double calculatePrice() {
        return basePrice + extraServiceFee;
    }

    public boolean isHasJacuzzi() {
        return hasJacuzzi;
    }

    public void setHasJacuzzi(boolean hasJacuzzi) {
        this.hasJacuzzi = hasJacuzzi;
    }

    public double getExtraServiceFee() {
        return extraServiceFee;
    }

    public void setExtraServiceFee(double extraServiceFee) {
        this.extraServiceFee = extraServiceFee;
    }

    @Override
    public String toString() {
        return "SuiteRoom{" +
                "id='" + id + '\'' +
                ", roomNumber='" + roomNumber + '\'' +
                ", basePrice=" + basePrice +
                ", hasJacuzzi=" + hasJacuzzi +
                ", extraServiceFee=" + extraServiceFee +
                ", finalPrice=" + calculatePrice() +
                '}';
    }
}