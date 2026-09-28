package com.hotel.repository;

import com.hotel.model.Invoice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InvoiceRepository implements GenericRepository<Invoice> {

    private static final Map<String, Invoice> invoiceMap = new HashMap<>();

    @Override
    public void add(Invoice invoice) {
        invoiceMap.put(invoice.getInvoiceId(), invoice);
    }

    @Override
    public void update(Invoice invoice) {
        invoiceMap.put(invoice.getInvoiceId(), invoice);
    }

    @Override
    public void delete(String invoiceId) {
        invoiceMap.remove(invoiceId);
    }

    @Override
    public Invoice findById(String invoiceId) {
        return invoiceMap.get(invoiceId);
    }

    @Override
    public List<Invoice> findAll() {
        return new ArrayList<>(invoiceMap.values());
    }
}