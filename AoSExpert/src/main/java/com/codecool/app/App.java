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
        String factPath = "src/main/java/com/codecool/app/dataBase/facts.xml";
        String rulePath = "src/main/java/com/codecool/app/dataBase/rules.xml";
        String ruleTag = "Rule";
        String factTag = "Fact";
        FactParser factParser = new FactParser(factPath, factTag);
        RuleParser ruleParser = new RuleParser(rulePath, ruleTag);
        ESProvider app = new ESProvider(factParser, ruleParser);
        app.collectAnswers();
        System.out.println(app.evaluate());

    }
}
