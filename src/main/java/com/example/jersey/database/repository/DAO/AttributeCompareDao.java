package com.example.jersey.database.repository.DAO;

import com.example.jersey.database.repository.DatabaseHelper_Repo;
import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AttributeCompareDao extends DatabaseHelper_Repo implements BusinessRuleDao{
    @Override
    public JSONObject getAll() {
        return null;
    }

    @Override
    public JSONObject get(JSONObject object) {
        return null;
    }

    @Override
    public void define(JSONObject object) {

        int rule_id = getRuleInitId();
        int composite_id = getInitId();

        try {
            connect();
            PreparedStatement statement = connection.prepareStatement("insert into ATTRIBUTECOMPARE (ID, TABLE1, COLUMN1, VALUE1, OPERATOR) values (?, ?, ?, ?, ?)");
            statement.setInt(1, composite_id);
            statement.setString(2, object.getString("table"));
            statement.setString(3, object.getString("column"));
            statement.setInt(4,object.getInt("value"));
            statement.setString(5,object.getString("operator"));
            statement.execute();

            statement = connection.prepareStatement("insert into BUSINESSRULE (ID, NAME, STATUS) values (?, ?, ?)");
            statement.setInt(1, rule_id);
            statement.setString(2, object.getString("name"));
            statement.setString(3, object.getString("status"));
            statement.execute();


            statement = connection.prepareStatement("insert into BUSINESSRULE_COMPOSITE (RULE_ID, ACR_ID) values (?,?)");
            statement.setInt(1,rule_id);
            statement.setInt(2,composite_id);
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

    @Override
    public int getInitId() {
        connect();
        int id = 0;
        try {
            PreparedStatement statement = connection.prepareStatement("select max(id) as max from attributecompare");
            ResultSet s = statement.executeQuery();
            while (s.next()){
                id = s.getInt("max");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        disconnect();
        if (id == 0){
            return 1;
        }
        return id + 1;
    }
}
