package com.codecool.app.facts;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Fact {
    private String name;
    private String description;
    private Map<String, Boolean> evaluations;

    public Fact(String name, String description) {
        this.name = name;
        this.description = description;
        this.evaluations = new HashMap<>();
    }

    public void setFactValueById(String id, boolean value) {
        this.evaluations.computeIfPresent(id, (k, v) -> v = value);
        this.evaluations.putIfAbsent(id, value);
    }

    public Set<String> getIdSet(){
        return this.evaluations.keySet();
    }

    public boolean getValueById(String id){
        return this.evaluations.get(id);
    }

    public String getDescription() {
        return this.description;
    }

    public String getName() {
        return this.name;
    }
}