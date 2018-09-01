package com.codecool.app;

import java.util.Iterator;
import java.util.Map;

public class RulesRepo{
    private Map <String, Question> rules;  
    private Iterator<Question> questionIterator;

    public RulesRepo(){
        this.questionIterator = new QuestionIterator<>();
    }

    public void addRule(Question question){

    }
}