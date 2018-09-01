package com.codecool.app.rules;

import java.util.ArrayList;
import java.util.List;

class SingleValue extends Value{
    private boolean value;
    private List<String> inputPattern;

    SingleValue(String param, boolean value){
        this.value = value;
        this.inputPattern = new ArrayList<>();
        this.inputPattern.add(param);
    }

    @Override
    public List<String> getInputPattern() {
        return this.inputPattern;
    }

    @Override
    public boolean getValue() {
        return this.value;
    }
}