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
            if(ruleNode instanceof Element){
                Element ruleElement = (Element) ruleNode;
                String id = ruleElement.getAttribute("id");
                Element questionElement = (Element) ruleElement.getElementsByTagName("Question").item(0);
                String question = questionElement.getTextContent();
                Answer answer = new Answer();
                fillAnswer(answer, ruleElement);
                this.rulesRepo.addRule(new Question(id, question, answer));
            }
        }
    }

    private void fillAnswer(Answer answer, Element ruleElement){
        NodeList selections = ruleElement.getElementsByTagName("Selection");
        for(int i = 0; i < selections.getLength(); i++){
            Node selectionNode = selections.item(i);
            if (selectionNode instanceof Element) {
                Element selection = (Element) selectionNode;
                boolean value = Boolean.valueOf(selection.getAttribute("value").toLowerCase());
                Element singleValueElement = (Element) selection.getElementsByTagName("SingleValue").item(0);
                String inputPattern = singleValueElement.getAttribute("value");
                SingleValue newSingleValue = new SingleValue(inputPattern, value);
                answer.addValue(newSingleValue);
            }
        }  
    }

    public RulesRepo getRulesRepo(){
        return this.rulesRepo;
    }
}