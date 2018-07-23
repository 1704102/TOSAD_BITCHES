package com.example.jersey.database;

import org.json.JSONObject;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class DatabaseFacade{

    DatabaseHelper_Repo database;

    public DatabaseFacade(){
        database = new DatabaseHelper_Repo();
    }
    public void defineBusinessRuleRule(ArrayList<String> query) {
        database.execute(query);
    }
}
