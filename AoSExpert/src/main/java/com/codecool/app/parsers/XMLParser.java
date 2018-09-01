package com.codecool.app.parsers;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Document;

public abstract class XMLParser{
    private Document document;
    private NodeList nodeList;

    public void loadXMLFile(String xmlPath, String tag){
        try {
            File xmlFile = new File(xmlPath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            this.document = dBuilder.parse(xmlFile);
            this.document.normalize();
            this.nodeList = this.document.getElementsByTagName(tag);
        } catch(Exception e) {
            e.printStackTrace();
        }
        // System.out.printf("Node: %s", this.document.getDocumentElement().getNodeName());
        
    }
}