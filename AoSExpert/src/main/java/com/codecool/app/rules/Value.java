package com.codecool.app.rules;

import java.util.List;

abstract class Value{

    abstract public List<String> getInputPatterns();
    abstract public boolean getValue();
}