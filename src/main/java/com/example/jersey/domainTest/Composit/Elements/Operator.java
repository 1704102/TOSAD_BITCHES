package com.example.jersey.domainTest.Composit.Elements;


import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Operator {

    private ArrayList<String> validator = new ArrayList<String>(Arrays.asList("!=", "=", "<", ">", "<=", ">="));

    private String value;

    public Operator(String value) {
        this.value = value;
    }

    public boolean validate(){
        return validator.contains(value);
    }

    public String getValue(){
        return value;
    }
}
