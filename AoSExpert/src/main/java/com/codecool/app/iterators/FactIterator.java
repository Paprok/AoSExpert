package com.codecool.app.iterators;

import com.codecool.app.facts.Fact;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FactIterator implements Iterator<Fact> {
    private List<Fact> facts;
    private int index;

    public FactIterator(Map<String, Fact> facts) {
        this.index = 0;
        this.facts = (ArrayList<Fact>) facts.values();
    }

    @Override
    public boolean hasNext() {
        return this.index < this.facts.size();
    }

    @Override
    public Fact next() {
        Fact nextFact = null;
        if (hasNext()) {
            nextFact = this.facts.get(this.index);
            this.index++;
        }
        return nextFact;
    }

    public void reset() {
        this.index = 0;
    }
}
