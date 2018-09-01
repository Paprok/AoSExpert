package com.codecool.app.rules;

import java.util.ArrayList;
import java.util.List;

class Answer{
    private List<Value> valueList;

    Answer(){
    this.valueList = new ArrayList<>();    
    }

    public boolean evaluateAnswerByInput(String input){
        boolean evaluation = false;
        for(Value value: this.valueList){
            if(value.getInputPattern().contains(input))
                evaluation = value.getValue();
        }
        return evaluation;
    }

    public void addValue(Value value){
        this.valueList.add(value);
    }
}