package com.example.oop_week11.repository;

import com.example.oop_week11.entity.SoccerEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public abstract class Repository<T extends SoccerEntity> {
    private final List<T> items;

    public Repository() {
        this.items = new ArrayList<>();
    }

    public List<T> getAll() {
        return items;
    }

    public void add(T item) {
        items.add(item);
    }

    public List<T> filter(Predicate<T> predicate) {
        return items.stream().filter(predicate).collect(Collectors.toList());
    }

    public List<T> filterByName(String name) {
        return filter(item -> item.getName().equals(name));
    }
}
