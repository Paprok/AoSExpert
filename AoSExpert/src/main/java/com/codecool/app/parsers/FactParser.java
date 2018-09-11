package com.codecool.app.parsers;

import com.codecool.app.facts.Fact;
import com.codecool.app.facts.FactsRepo;
import com.codecool.app.rules.Answer;
import com.codecool.app.rules.Question;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class FactParser extends XMLParser {
    private NodeList nodeList;
    private FactsRepo factsRepo;


    public FactParser(String xmlPath, String tag) {
        this.nodeList = loadXMLFile(xmlPath, tag);
        this.factsRepo = new FactsRepo();
        fillFactRepo();
    }

    private void fillFactRepo(){
        for(int i = 0; i < this.nodeList.getLength(); i++) {
            Node factNode = this.nodeList.item(i);
            if (factNode instanceof Element) {
                Element factElement = (Element) factNode;
                String factName = factElement.getAttribute("id");
                Element descriptionElement = (Element) factElement.getElementsByTagName("Description").item(0);
                String description = descriptionElement.getAttribute("value");
                NodeList evalsList = factElement.getElementsByTagName("Eval");
                Fact fact = createFact(factName, description, evalsList);
                this.factsRepo.addFact(fact);
            }
        }
    }

    private Fact createFact(String factName, String description, NodeList evalsList){
        Fact fact = new Fact(factName, description);
        for(int j=0; j < evalsList.getLength(); j++){
            Node evalNode = evalsList.item(j);
            if(evalNode instanceof  Element){
                Element evalElement = (Element) evalNode;
                String id = evalElement.getAttribute("id");
                String value = evalElement.getTextContent();
                fact.setFactValueById(id, Boolean.valueOf(value));
            }
        }
        return fact;
    }

    public FactsRepo getFactsRepo() {
        return this.factsRepo;
    }
}