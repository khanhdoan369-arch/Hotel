package com.hotel.service;

import com.hotel.exception.CustomerNotFoundException;
import com.hotel.model.Customer;
import com.hotel.repository.CustomerRepository;

import java.util.List;

public class CustomerService {

    private final CustomerRepository repository;

    public CustomerService() {
        repository = new CustomerRepository();
    }

    /**
     * Thêm thông tin khách hàng.
     */
        public void addCustomer(Customer customer) {
            repository.add(customer);
    }

    /**
     * Cập nhật thông tin khách hàng.
     */
    public void updateCustomer(Customer customer)
            throws CustomerNotFoundException {

        if (repository.findById(customer.getCustomerId()) == null) {
            throw new CustomerNotFoundException("Customer not found.");
        }

        repository.update(customer);
    }

    /**
     * Xoá thông tin khách hàng.
     */
    public void deleteCustomer(String customerId)
            throws CustomerNotFoundException {

        if (repository.findById(customerId) == null) {
            throw new CustomerNotFoundException("Customer not found.");
        }

        repository.delete(customerId);
    }

    /**
     * Tìm thông tin khách hàng bằng ID.
     */
    public Customer findCustomerById(String customerId)
            throws CustomerNotFoundException {

        Customer customer = repository.findById(customerId);

        if (customer == null) {
            throw new CustomerNotFoundException("Customer not found.");
        }

        return customer;
    }

    /**
     * In ra tất cả thông tion khách hàng còn lưu trữ.
     */
    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }

}