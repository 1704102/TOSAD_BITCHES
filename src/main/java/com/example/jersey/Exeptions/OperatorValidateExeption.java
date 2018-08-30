package com.example.jersey.Exeptions;

public class OperatorValidateExeption extends Exception {

    public OperatorValidateExeption(){
        super("{\"error\":\"not a valid operator\"}");
    }
}
