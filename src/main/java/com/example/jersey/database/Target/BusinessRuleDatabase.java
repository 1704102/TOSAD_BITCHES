package com.example.jersey.database.Target;

import org.json.JSONObject;

import java.sql.PreparedStatement;

public class BusinessRuleDatabase extends DatabaseHelper_Target {

    public void activateConstraint(JSONObject object) throws Exception{
        connect();
        PreparedStatement statement = connection.prepareStatement("alter table " + object.getString("table1") + " ENABLE constraint " + object.getString("name"));
        statement.execute();
        disconnect();
    }

    public void deactivateConstraint(JSONObject object) throws Exception{
        connect();
        PreparedStatement statement = connection.prepareStatement("alter table " + object.getString("table1") + " DISABLE constraint " + object.getString("name"));
        statement.execute();
        disconnect();
    }

    public void deleteConstraint(JSONObject object) throws Exception{
        connect();
        PreparedStatement statement = connection.prepareStatement("ALTER TABLE " + object.getString("table1") + " DROP CONSTRAINt " + object.getString("name"));
        statement.execute();
        disconnect();
    }
}
