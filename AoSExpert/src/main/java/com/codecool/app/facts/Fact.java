package com.codecool.app.facts;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Fact {
    private String name;
    private String description;
    private Map<String, Boolean> evals;

    public Fact(String name, String description) {
        this.name = name;
        this.description = description;
        this.evals = new HashMap<>();
    }

    public void setFactValueById(String id, boolean value) {
        this.evals.computeIfPresent(id, (k, v) -> v = value);
        this.evals.putIfAbsent(id, value);
    }

    public Set<String> getIdSet(){
        return this.evals.keySet();
    }

    public boolean getValueById(String id){
        return this.evals.get(id);
    }

    public String getDescription() {
        return this.description;
    }

    public String getName() {
        return this.name;
    }
}