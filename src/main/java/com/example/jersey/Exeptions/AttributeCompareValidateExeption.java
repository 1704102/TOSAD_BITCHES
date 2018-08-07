package com.example.jersey.Exeptions;

public class AttributeCompareValidateExeption extends Exception{
    public AttributeCompareValidateExeption(){
        super("not a valid attribute compare rule");
    }
}
