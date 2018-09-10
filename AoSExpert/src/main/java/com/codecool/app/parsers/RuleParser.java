package com.codecool.app.parsers;
import com.codecool.app.rules.Question;
import com.codecool.app.rules.RulesRepo;
import com.codecool.app.rules.Answer;
import com.codecool.app.rules.SingleValue;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class RuleParser extends XMLParser{
    private RulesRepo rulesRepo;
    private NodeList nodeList;

    // public static void main(String[] args) {
    // XMLParser dupa = new RuleParser();
    // dupa.loadXMLFile("/home/ferned/Code/Java/SI_5/AoSExpert/src/main/java/com/codecool/app/dataBase/rules.xml");    
    // }

    public RuleParser(String xmlPath, String tag){
        this.nodeList = loadXMLFile(xmlPath, tag);
        this.rulesRepo = new RulesRepo();
        fillRulesRepo();
    }

    /**Could be in XMLParser if RulesRepo and FactRepo would inherit from same class */
    private void fillRulesRepo(){
        for(int i = 0; i < this.nodeList.getLength(); i++){
            Node ruleNode = this.nodeList.item(i);
            System.out.printf("%s", ruleNode.getNodeName());
            if(ruleNode instanceof Element){
                Element rule = (Element) ruleNode;
                String id = rule.getAttribute("id");
                String question = rule.getElementsByTagName("Question").item(0).getTextContent();
                Answer answer = new Answer();
                fillAnswer(answer, rule);
                this.rulesRepo.addRule(new Question(id, question, answer));
                // System.out.printf("Selection value %s\n", selection.getAttribute("value"));
                // System.out.printf("Answer: %s\n", singleValue.getAttribute("value"));
                // Element selection1 = (Element) rule.getElementsByTagName("Selection").item(1);
                // System.out.printf("Selection value %s\n", selection1.getAttribute("value"));
                // Element singleValue1 = (Element) selection1.getElementsByTagName("SingleValue").item(0);
                // System.out.printf("Answer: %s\n", singleValue1.getAttribute("value"));
            }
        }
    }

    private void fillAnswer(Answer answer, Element rule){
        for(int i = 0; i < rule.getElementsByTagName("Selection").getLength(); i++){
            Element selection = (Element) rule.getElementsByTagName("Selection").item(i);
            Element singleValue = (Element) selection.getElementsByTagName("SingleValue").item(0);
            answer.addValue(new SingleValue(singleValue.getAttribute("value"), Boolean.getBoolean(selection.getAttribute("value"))));
        }  
    }

    public RulesRepo getRulesRepo(){
        return this.rulesRepo;
    }
}