package com.codecool.app.rules;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.codecool.app.iterators.QuestionIterator;

public class RulesRepo {
    private Map<String, Question> rules;
    private Iterator<Question> questionIterator;

    public RulesRepo() {
        this.rules = new HashMap<>();
    }

    public void addRule(Question question) {
        this.rules.put(question.getId(), question);
    }

    public Map<String, Question> getRules() {
        return this.rules;
    }

    public Iterator<Question> getIterator() {
        this.questionIterator = new QuestionIterator(this.rules);
        return this.questionIterator;
    }

    public boolean getEvaluatedAnswerById(String id) {
        return this.rules.get(id).getEvaluatedAnswer();
    }
}