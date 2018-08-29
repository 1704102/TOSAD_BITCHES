package com.example.jersey.database.Target;

import org.json.JSONObject;

import java.sql.PreparedStatement;

public class BusinessRuleDatabase extends DatabaseHelper_Target {

    public void activateConstraint(JSONObject object) throws Exception{
        connect();
        PreparedStatement statement = connection.prepareStatement("ALTER TRIGGER " + object.getString("name") + " ENABLE");
        statement.execute();
        disconnect();
    }

    public void deactivateConstraint(JSONObject object) throws Exception{
        connect();
        PreparedStatement statement = connection.prepareStatement("ALTER TRIGGER " + object.getString("name") + " DISABLE");
        statement.execute();
        disconnect();
    }

    public void deleteConstraint(JSONObject object) throws Exception{
        connect();
        PreparedStatement statement = connection.prepareStatement("DROP TRIGGER " + object.getString("name"));
        statement.execute();
        disconnect();
    }
}
