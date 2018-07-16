package com.example.jersey.database;

import org.json.JSONObject;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class DatabaseFacade extends DatabaseHelper_Repo{
    public void defineAttributeRangeRule(ArrayList<String> query) {

        connect();
        query.forEach(subQuery->{
            PreparedStatement statement = getPreparedStatement(subQuery);
            try {
                statement.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

        disconnect();
    }
}
