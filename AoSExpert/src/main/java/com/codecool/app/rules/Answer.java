package com.codecool.app.rules;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Answer{
    private List<Value> valueList;

    public Answer(){
    this.valueList = new ArrayList<>();    
    }

    public boolean evaluateAnswerByInput(String input) throws IOException {
        for(Value value: this.valueList){
            if(value.getInputPattern().contains(input))
                return value.getValue();
        }
        throw new IOException();
    }

    public void addValue(Value value){
        this.valueList.add(value);
    }
}