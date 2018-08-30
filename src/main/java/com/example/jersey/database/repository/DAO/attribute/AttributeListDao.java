package com.example.jersey.database.repository.DAO.attribute;

import com.example.jersey.database.repository.DAO.BusinessRuleDao;
import com.example.jersey.database.repository.DatabaseHelper_Repo;
import com.example.jersey.util.Util;
import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AttributeListDao extends DatabaseHelper_Repo implements BusinessRuleDao {


    @Override
    public JSONObject getAll(JSONObject object) throws Exception {
        connect();
        PreparedStatement statement = connection.prepareStatement("select a.id as rule_id, a.name, a.status, c.id as composite_id, c.table1, c.column1, c.list from businessrule a left join businessrule_composite b on a.id = b.rule_id left join attributelist c on b.alr_id = c.id where b.alr_id is not null and a.database_id = ?");
        statement.setInt(1, object.getInt("database_id"));
        ResultSet s = statement.executeQuery();
        JSONObject output = Util.ResultSetToJSONArray(s, "alr");
        disconnect();
        return output;
    }

    @Override
    public JSONObject get(JSONObject object) throws Exception{
        connect();
        PreparedStatement statement = connection.prepareStatement("select a.id as rule_id, a.name, a.status, c.id as composite_id, c.table1, c.column1, c.list from businessrule a left join businessrule_composite b on a.id = b.rule_id left join attributelist c on b.alr_id = c.id where b.alr_id is not null and a.id = ?");
        statement.setInt(1, object.getInt("id"));
        ResultSet s = statement.executeQuery();
        JSONObject output = Util.ResultSetToJSONObject(s, "alr");
        disconnect();
        return output;
    }

    @Override
    public void define(JSONObject object) throws Exception {
        int rule_id = getId("businessRule");
        int composite_id = getId("attributeList");

        StringBuilder list = new StringBuilder();
        for (int i = 0; i < object.getJSONArray("list").length(); i++){
            list.append(object.getJSONArray("list").getString(i) + ";");
        }
        list.deleteCharAt(list.length() - 1);

        connect();
        PreparedStatement statement = connection.prepareStatement("insert into ATTRIBUTELIST (ID, TABLE1, COLUMN1, LIST) values (?, ?, ?, ?)");
        statement.setInt(1, composite_id);
        statement.setString(2, object.getString("table1"));
        statement.setString(3, object.getString("column1"));
        statement.setString(4,list.toString());
        statement.execute();

        insertRule(object ,rule_id, composite_id);

        statement = connection.prepareStatement("insert into BUSINESSRULE_COMPOSITE (RULE_ID, ALR_ID) values (?,?)");
        statement.setInt(1,rule_id);
        statement.setInt(2,composite_id);
        statement.execute();

        disconnect();
    }

    @Override
    public void update(JSONObject object, int id, int comp_id)throws Exception {
        connect();

        StringBuilder list = new StringBuilder();
        for (int i = 0; i < object.getJSONArray("list").length(); i++){
            list.append(object.getJSONArray("list").getString(i) + ";");
        }
        list.deleteCharAt(list.length() - 1);

        PreparedStatement statement = connection.prepareStatement("update ATTRIBUTELIST set TABLE1 = ?, COLUMN1 = ?, LIST = ? where ID = ?");
        statement.setString(1, object.getString("table1"));
        statement.setString(2, object.getString("column1"));
        statement.setString(3, list.toString());
        statement.setInt(4, comp_id);
        statement.execute();

        saveRule(object, id);

        disconnect();
    }

}
