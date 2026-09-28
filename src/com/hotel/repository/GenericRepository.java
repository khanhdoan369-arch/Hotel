package com.hotel.repository;

import java.util.List;

public interface GenericRepository<T> {

    void add(T item);

    void update(T item);

    void delete(String id);

    T findById(String id);

    List<T> findAll();

}