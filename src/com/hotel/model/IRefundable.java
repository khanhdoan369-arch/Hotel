package com.hotel.model;

/**
 * Interface for bookings that support refunds.
 */
public interface IRefundable {

    /**
     * Calculate the refund amount.
     *
     * @return refund amount
     */
    double calculateRefund();

}