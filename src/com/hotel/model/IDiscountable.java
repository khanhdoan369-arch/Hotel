package com.hotel.model;

/**
 * Interface for rooms that support discounts.
 */
public interface IDiscountable {

    /**
     * Calculate the discount amount.
     *
     * @return discount amount
     */
    double calculateDiscount();

}