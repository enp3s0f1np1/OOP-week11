package com.example.oop_week11.iterator;

import com.example.oop_week11.entity.SoccerEntity;

import java.util.Iterator;

public interface EntityIterator<T extends SoccerEntity> extends Iterator<T> {
}
