package com.hotel.repository;

import java.util.ArrayList;
import java.util.List;

public class GenericRepository<T> {

    protected List<T> items;

    public GenericRepository() {
        items = new ArrayList<>();
    }

    public void add(T item) {
        items.add(item);
    }

    public List<T> getAll() {
        return items;
    }

    public void remove(T item) {
        items.remove(item);
    }

    public int size() {
        return items.size();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}
