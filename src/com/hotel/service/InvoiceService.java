package com.hotel.service;

import com.hotel.model.Invoice;
import com.hotel.repository.InvoiceRepository;

import java.util.List;

public class InvoiceService {

    private final InvoiceRepository repository;

    public InvoiceService() {
        repository = new InvoiceRepository();
    }

    /**
     * Thêm hoá đơn.
     */
    public void addInvoice(Invoice invoice) {

        invoice.calculateTotalAmount();

        repository.add(invoice);
    }

    /**
     * Cập nhật hoá đơn.
     */
    public void updateInvoice(Invoice invoice) {

        invoice.calculateTotalAmount();

        repository.update(invoice);
    }

    /**
     * Xoá hoá đơn.
     */
    public void deleteInvoice(String invoiceId) {

        repository.delete(invoiceId);
    }

    /**
     * Tìm thông tin bằng ID hoá đơn.
     */
    public Invoice findInvoiceById(String invoiceId) {

        return repository.findById(invoiceId);
    }

    /**
     * Lấy tất cả thông tin háo đơn còn lưu trữ.
     */
    public List<Invoice> getAllInvoices() {

        return repository.findAll();
    }

}