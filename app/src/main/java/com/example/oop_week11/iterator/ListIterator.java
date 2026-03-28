package com.example.oop_week11.iterator;

import com.example.oop_week11.entity.SoccerEntity;

import java.util.List;
import java.util.NoSuchElementException;

public class ListIterator<T extends SoccerEntity> implements EntityIterator<T> {
    private final List<T> entities;
    private int currentIndex;

    public ListIterator(List<T> entities) {
        this.entities = entities;
        this.currentIndex = 0;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < entities.size();
    }

    @Override
    public T next() {
        return entities.get(currentIndex++);
    }
}
