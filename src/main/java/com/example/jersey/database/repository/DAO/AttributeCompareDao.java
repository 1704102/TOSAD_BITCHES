package com.example.jersey.database.repository.DAO;

import com.example.jersey.database.repository.DatabaseHelper_Repo;
import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AttributeCompareDao extends DatabaseHelper_Repo implements BusinessRuleDao{
    @Override
    public JSONArray getAll(JSONObject object) {
        return null;
    }

    @Override
    public JSONObject get(JSONObject object) {
        return null;
    }

    @Override
    public void define(JSONObject object) {
        try {
            connect();
            PreparedStatement statement = connection.prepareStatement("insert into ATTRIBUTECOMPARE (ID, TABLE1, COLUMN1, VALUE1, OPERATOR) values (?, ?, ?, ?, ?)");
            statement.setInt(1,1);
            statement.setString(2, object.getString("table"));
            statement.setString(3, object.getString("column"));
            statement.setInt(4,object.getInt("value"));
            statement.setString(5,object.getString("operator"));
            statement.execute();

            statement = connection.prepareStatement("insert into BUSINESSRULE (ID, NAME, STATUS) values (?, ?, ?)");
            statement.setInt(1, 1);
            statement.setString(2, object.getString("name"));
            statement.setString(3, object.getString("status"));


            statement = connection.prepareStatement("insert into BUSINESSRULE_COMPONENT (BUSINESSRULE_ID, ATTRIBUTECOMPARE_ID) values (?,?)");
            statement.setInt(1,1);
            statement.setInt(2,1);
            statement.execute();
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(JSONObject object) {

    }

    @Override
    public void delete(JSONObject object) {

    }
}
