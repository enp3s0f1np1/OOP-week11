package com.example.oop_week11.iterator;

import com.example.oop_week11.entity.Match;

import java.util.List;

public class MatchIterator extends ListIterator<Match> {
    public MatchIterator(List<Match> matches) {
        super(matches);
    }
}
