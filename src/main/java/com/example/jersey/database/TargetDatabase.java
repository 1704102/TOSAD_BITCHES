package com.example.jersey.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TargetDatabase extends DatabaseHelper {

    public void saveRule(String sql){
        connect();
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();
        }catch (Exception e){e.printStackTrace();}
        disconnect();
    }
}
