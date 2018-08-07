package com.example.jersey.Exeptions;

public class AttributeRangeValidateExeption extends Exception {

    public AttributeRangeValidateExeption(){
        super("not a valid attribute range rule");
    }
}
