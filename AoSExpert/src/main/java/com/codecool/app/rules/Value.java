package com.codecool.app.rules;

import java.util.List;

abstract class Value{

    abstract List<String> getInputPattern();
    abstract boolean getValue();
}