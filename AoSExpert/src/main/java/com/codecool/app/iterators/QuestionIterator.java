package com.codecool.app.iterators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import com.codecool.app.rules.*;

public class QuestionIterator implements Iterator<Question> {
    private ArrayList<Question> questions;
    private int index;

    public QuestionIterator(Map<String, Question> rules) {
        this.index = 0;
        this.questions = (ArrayList<Question>) rules.values();
    }

    @Override
    public boolean hasNext() {
        return this.index < this.questions.size();
    }

    @Override
    public Question next() {
        Question nextQuestion = null;
        if (hasNext()) {
            nextQuestion = this.questions.get(this.index);
            this.index++;
        }
        return nextQuestion;
    }

    public void reset() {
        this.index = 0;
    }
}