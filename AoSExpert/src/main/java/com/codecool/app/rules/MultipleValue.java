package com.codecool.app.rules;

import java.util.List;

class MultipleValue extends Value{
    private boolean value;
    private List<String> inputPattern;

    MultipleValue(List<String> params, boolean value){
        this.value = value;
        this.inputPattern = params;
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