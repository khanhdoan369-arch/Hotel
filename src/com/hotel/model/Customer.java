package com.hotel.model;

public class Customer {

    private String customerId;
    private String fullName;
    private String phone;
    private String identityNumber;
    private boolean vip;

    public Customer() {
    }

    public Customer(String customerId,
                    String fullName,
                    String phone,
                    String identityNumber,
                    boolean vip) {

        this.customerId = customerId;
        this.fullName = fullName;
        this.phone = phone;
        this.identityNumber = identityNumber;
        this.vip = vip;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", fullName='" + fullName + '\'' +
                ", phone='" + phone + '\'' +
                ", identityNumber='" + identityNumber + '\'' +
                ", vip=" + vip +
                '}';
    }
}