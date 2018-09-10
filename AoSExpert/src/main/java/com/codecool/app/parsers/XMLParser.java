package com.codecool.app.parsers;

import java.io.File;
// import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
// import org.w3c.dom.Element;
// import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
// import org.w3c.dom.Document;

class XMLParser{
    NodeList loadXMLFile(String xmlPath, String tag){
        NodeList nodeList = null;
        try {
            File xmlFile = new File(xmlPath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document document = dBuilder.parse(xmlFile);
            document.normalize();
            nodeList = document.getElementsByTagName(tag);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return nodeList;
    }
}