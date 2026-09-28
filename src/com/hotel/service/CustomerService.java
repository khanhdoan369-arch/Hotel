package com.hotel.service;

import com.hotel.model.Customer;
import com.hotel.repository.CustomerRepository;

import java.util.List;

public class CustomerService {

    private final CustomerRepository repository;

    public CustomerService() {
        repository = new CustomerRepository();
    }

    public void addCustomer(Customer customer) {
        repository.add(customer);
    }

    public Customer findCustomer(String id) {
        return repository.findById(id);
    }

    public List<Customer> getAllCustomers() {
        return repository.getAll();
    }

}
