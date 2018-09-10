package com.codecool.app;

import com.codecool.app.parsers.FactParser;
import com.codecool.app.parsers.RuleParser;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String factPath = "/home/ferned/Code/Java/SI_5/AoSExpert/src/main/java/com/codecool/app/dataBase/facts.xml";
        factPath = "facts.xml";
        String rulePath = "/home/ferned/Code/Java/SI_5/AoSExpert/src/main/java/com/codecool/app/dataBase/rules.xml";
        rulePath = "rules.xml";
        String ruleTag = "Rule";
        String factTag = "Fact";
        FactParser factParser = new FactParser(factPath, factTag);
        RuleParser ruleParser = new RuleParser(rulePath, ruleTag);
        ESProvider app = new ESProvider(factParser, ruleParser);
        
    }
}
