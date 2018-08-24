package com.example.jersey.database.repository.DAO.attribute;

import com.example.jersey.database.repository.DAO.BusinessRuleDao;
import com.example.jersey.database.repository.DatabaseHelper_Repo;
import org.json.JSONObject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AttributeOtherDao extends DatabaseHelper_Repo implements BusinessRuleDao{
    @Override
    public JSONObject getAll(JSONObject object) throws Exception {
        return null;
    }

    @Override
    public JSONObject get(JSONObject object) throws Exception {
        return null;
    }

    @Override
    public void define(JSONObject object) throws Exception {
        int rule_id = getId("businessRule");
        int composite_id = getId("attributeOther");

        connect();
        PreparedStatement statement = connection.prepareStatement("insert into ATTRIBUTEOTHER (ID, TABLE1, TYPE, CODE) values (?, ?, ?, ?)");
        statement.setInt(1, composite_id);
        statement.setString(2, object.getString("table1"));
        statement.setString(3, object.getString("type"));
        statement.setString(4,object.getString("plSQL"));
        statement.execute();

        insertRule(object ,rule_id);

        statement = connection.prepareStatement("insert into BUSINESSRULE_COMPOSITE (RULE_ID, AOR_ID) values (?,?)");
        statement.setInt(1,rule_id);
        statement.setInt(2,composite_id);
        statement.execute();

        disconnect();
    }

    @Override
    public void update(JSONObject object) throws Exception {

        connect();

        saveRule(object);

        disconnect();
    }


}
