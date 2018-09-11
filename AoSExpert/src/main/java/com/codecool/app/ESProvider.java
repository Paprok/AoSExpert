package com.codecool.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Iterator;

import com.codecool.app.facts.Fact;
import com.codecool.app.facts.FactsRepo;
import com.codecool.app.parsers.*;
import com.codecool.app.rules.*;

public class ESProvider{
    private RulesRepo rulesRepo;
    private FactsRepo factsRepo;
    private Iterator<Question> questionIterator;
    private String suggestion;


    public ESProvider(FactParser factParser, RuleParser ruleParser){
        this.rulesRepo = ruleParser.getRulesRepo();
        this.factsRepo = factParser.getFactsRepo();
        this.suggestion = "Army for you not found, wait for future update!\n Sorry for inconvenience";
    }

    public void collectAnswers(){
        this.questionIterator = this.rulesRepo.getIterator();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(this.questionIterator.hasNext()){
            Question newQuestion = this.questionIterator.next();
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
            } catch (InputMismatchException e){
                System.out.println("Wrong input");
            } catch (IOException e){
                System.out.println("Couldn't find file");
                e.printStackTrace();
            }
        }
    }
    public String evaluate(){
        boolean isSuggestionFound = false;
        Iterator<Fact> factIterator = factsRepo.getIterator();
        while(factIterator.hasNext() && !isSuggestionFound){
            Fact nextFact = factIterator.next();
            isSuggestionFound = checkIsFactMatchingAnswers(nextFact);

        }
        return this.suggestion;
    }

    private boolean checkIsFactMatchingAnswers(Fact fact){
        /** TO REMAKE USING GET SET AND FOR*/
        boolean isFactMatchingAnswers = false;
        if(isMatch(fact, "aggro")){
            if(isMatch(fact, "good")){
                if(isMatch(fact, "monsters")){
                    isFactMatchingAnswers = true;
                    this.suggestion = fact.getDescription();
                }
            }
        }
        return isFactMatchingAnswers;
    }

    private boolean isMatch(Fact fact, String ruleId){
        return fact.getValueById(ruleId) == getAnswerById(ruleId);
    }


    public boolean getAnswerById(String ruleId){
        return this.rulesRepo.getEvaluatedAnswerById(ruleId);
    }
}