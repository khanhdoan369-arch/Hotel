package com.hotel.repository;

import com.hotel.model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerRepository implements GenericRepository<Customer> {

    private static final Map<String, Customer> customerMap = new HashMap<>();

    @Override
    public void add(Customer customer) {
        customerMap.put(customer.getCustomerId(), customer);
    }

    @Override
    public void update(Customer customer) {
        customerMap.put(customer.getCustomerId(), customer);
    }

    @Override
    public void delete(String customerId) {
        customerMap.remove(customerId);
    }

    @Override
    public Customer findById(String customerId) {
        return customerMap.get(customerId);
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customerMap.values());
    }
}