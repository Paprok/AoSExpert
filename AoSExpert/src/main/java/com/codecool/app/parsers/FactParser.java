package com.codecool.app.parsers;


public class FactParser extends XMLParser{
    public FactParser(String xmlPath, String tag){
        loadXMLFile(xmlPath, tag);
    }
}