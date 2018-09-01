package com.codecool.app.parsers;
import com.codecool.app.rules.RulesRepo;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class RuleParser extends XMLParser{
    private RulesRepo rulesRepo;
    private Document document;
    private NodeList nodeList;

    // public static void main(String[] args) {
    // XMLParser dupa = new RuleParser();
    // dupa.loadXMLFile("/home/ferned/Code/Java/SI_5/AoSExpert/src/main/java/com/codecool/app/dataBase/rules.xml");    
    // }

    public RuleParser(String xmlPath, String tag){
        loadXMLFile(xmlPath, tag);
    }

    public RulesRepo getRulesRepo(){
        this.rulesRepo = new RulesRepo();
        fillRulesRepo();
        return rulesRepo;
    }

    private void fillRulesRepo(){
        for(int i = 0; i < this.nodeList.getLength(); i++){
            Node ruleNode = this.nodeList.item(i);
            System.out.printf("%s", ruleNode.getNodeName());
            if(ruleNode instanceof Element){
                Element rule = (Element) ruleNode;
                System.out.printf(" id: %s\n", rule.getAttribute("id"));
                System.out.printf("Question: %s\n", rule.getElementsByTagName("Question").item(0).getTextContent());
                Element selection = (Element) rule.getElementsByTagName("Selection").item(0);
                System.out.printf("Selection value %s\n", selection.getAttribute("value"));
                Element singleValue = (Element) selection.getElementsByTagName("SingleValue").item(0);
                System.out.printf("Answer: %s\n", singleValue.getAttribute("value"));
            }
        }
    }
}