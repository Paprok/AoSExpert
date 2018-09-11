package com.codecool.app.rules;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class Answer {
    private List<Value> valueList;

    public Answer() {
        this.valueList = new ArrayList<>();
    }

    public boolean evaluateAnswerByInput(String input) {
        String formattedInput = input.toLowerCase().trim();
        for (Value value : this.valueList) {
            if (value.getInputPatterns().contains(formattedInput)) {
                boolean evaluation = value.getValue();
                return evaluation;
            }
        }
        throw new InputMismatchException();
    }

    public void addValue(Value value) {
        this.valueList.add(value);
    }
}