package com.codecool.app.parsers;

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
        loadXMLFile(xmlPath, tag);
        this.factsRepo = new FactsRepo();
        fillFactRepo();
    }

    private void fillFactRepo(){
        /** CHANGE THIS SHIT TO FACTS MATE :D */
        for(int i = 0; i < this.nodeList.getLength(); i++) {
            Node ruleNode = this.nodeList.item(i);
            System.out.printf("%s", ruleNode.getNodeName());
            if (ruleNode instanceof Element) {
                Element rule = (Element) ruleNode;
                String id = rule.getAttribute("id");
                String question = rule.getElementsByTagName("Question").item(0).getTextContent();
                Answer answer = new Answer();
                fillAnswer(answer, rule);
                this.rulesRepo.addRule(new Question(id, question, answer));
            }
        }
    }

    public FactsRepo getFactsRepo() {
        return this.factsRepo;
    }
}