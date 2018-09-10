package com.codecool.app.facts;

import com.codecool.app.iterators.FactIterator;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FactsRepo {
    private Map<String, Fact> facts;

    public FactsRepo() {
        this.facts = new HashMap<>();
    }

    public void addFact(Fact fact) {
        this.facts.put(fact.getName(), fact);
    }

    public Iterator<Fact> getIterator() {

        return new FactIterator(this.facts);
    }

    public Map<String, Fact> getFacts() {
        return this.facts;
    }
}