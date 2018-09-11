package com.codecool.app.rules;

import java.util.ArrayList;
import java.util.List;

public class SingleValue extends Value{
    private boolean value;
    private List<String> inputPatterns;

    public SingleValue(String inputPattern, boolean value){
        this.value = value;
        this.inputPatterns = new ArrayList<>();
        this.inputPatterns.add(inputPattern.toLowerCase());
    }

    @Override
    public List<String> getInputPatterns() {
        return this.inputPatterns;
    }

    @Override
    public boolean getValue() {
        return this.value;
    }
}