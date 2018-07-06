package com.example.jersey.Generator;

import com.example.jersey.database.DatabaseHelper;

import java.sql.PreparedStatement;

public class BusinessRuleMaintainer {

    public void activate(){
        String table = "";
        String constraint = "";
        DatabaseHelper database = new DatabaseHelper();
        database.connect();
        PreparedStatement statement = database.getPreparedStatement("alter table ? Enable constraint ?");
        try {
            statement.setString(1, table);
            statement.setString(2, constraint);
        }catch (Exception e){
            e.printStackTrace();
        }

        database.disconnect();
    }

    public void deActivate(){
        String table = "";
        String constraint = "";
        DatabaseHelper database = new DatabaseHelper();
        database.connect();
        PreparedStatement statement = database.getPreparedStatement("alter table ? DISABLE constraint ?");
        try {
            statement.setString(1, table);
            statement.setString(2, constraint);
        }catch (Exception e){
            e.printStackTrace();
        }

        database.disconnect();
    }
}
