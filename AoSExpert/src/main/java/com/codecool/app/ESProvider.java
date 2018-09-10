package com.codecool.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Iterator;

import com.codecool.app.parsers.*;
import com.codecool.app.rules.*;

public class ESProvider{
    private RulesRepo rulesRepo;
    private Iterator<Question> iterator;
    
    public ESProvider(FactParser factParser, RuleParser ruleParser){
        this.rulesRepo = ruleParser.getRulesRepo();

    }

    public void collectAnswers(){
        this.iterator = this.rulesRepo.getIterator();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(this.iterator.hasNext()){
            Question newQuestion = this.iterator.next();
            evaluateAnswer(newQuestion, reader);
        }
    }

    private void evaluateAnswer(Question newQuestion, BufferedReader reader){
        boolean isWrongInput = true;        
        while(isWrongInput){
            try{
                System.out.println(newQuestion.getQuestion());
                String input = reader.readLine(); 
                newQuestion.evaluateAnswer(input);
                isWrongInput = false;
            } catch (IOException e){
                System.out.println("Wrong input");
            }
        }
    }

    public boolean getAnswerById(String id){
        return this.rulesRepo.getRules().get(id).getEvaluatedAnswer();
    }
}