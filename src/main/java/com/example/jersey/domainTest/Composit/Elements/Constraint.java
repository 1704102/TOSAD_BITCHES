package com.example.jersey.domainTest.Composit.Elements;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;

public class Constraint {

    private ArrayList<String> types = new ArrayList<String>(Arrays.asList(
            "NOT NULL",
            "UNIQUE",
            "PRIMARY KEY",
            "FOREIGN KEY",
            "CHECK", // only fit for attribute other rule
            "DEFAULT", // Sets a default value for a column when no value is specified
            "INDEX" // Used to create and retrieve data from the database very quickly
    ));

    private String type;
    private String plSQL;

    public Constraint (String plSQL) {
        this.plSQL = plSQL;
        getType();
    }

    public void getType(){
        String[] split = plSQL.split(" ");
        switch (split[0]){
            case "NOT" : type = "NOT NULL"; break;
            case "UNIQUE" : type = "UNIQUE"; break;
            case "PRIMARY" : type = "PRIMARY KEY"; break;
            case "FOREIGN" : type = "FOREIGN KEY"; break;
            case "CHECK" : type = "CHECK"; break;
            case "DEFAULT" : type = "DEFAULT"; break;
            case "INDEX" : type = "INDEX"; break;
            default : type = "other rule"; break;
        }
    }

    public boolean validate(){
        return types.contains(type);
    }

    public JSONObject getConstraint(){
        JSONObject object= new JSONObject();
        object.put("type", type);
        object.put("plSQL", plSQL);
        return object;
    }

}
