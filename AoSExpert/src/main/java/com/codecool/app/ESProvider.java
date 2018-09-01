package com.codecool.app;

import com.codecool.app.parsers.*;

public class ESProvider{
    private RuleRepository ruleRepository;
    
    public ESProvider(FactParser factParser, RuleParser ruleParser){
        this.ruleRepository = ruleParser.getRuleRepository();

    }
}