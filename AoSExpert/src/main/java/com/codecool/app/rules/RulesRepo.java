package com.codecool.app.rules;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.codecool.app.QuestionIterator;

public class RulesRepo{
    private Map <String, Question> rules;  
    private Iterator<Question> questionIterator;

    public RulesRepo(){
        this.rules = new HashMap<>();
        this.questionIterator = new QuestionIterator();
    }

    public void addRule(Question question){
        this.rules.put(question.getId(), question);
    }

    public Iterator<Question> getIterator(){
        return this.questionIterator;
    }