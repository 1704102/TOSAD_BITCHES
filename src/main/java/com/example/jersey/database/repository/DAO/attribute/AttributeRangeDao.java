package com.example.jersey.database.repository.DAO.attribute;

import com.example.jersey.database.repository.DAO.BusinessRuleDao;
import com.example.jersey.database.repository.DatabaseHelper_Repo;
import com.example.jersey.util.Util;
import com.mysql.cj.protocol.Resultset;
import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class AttributeRangeDao extends DatabaseHelper_Repo implements BusinessRuleDao {
    @Override
    public JSONObject getAll(JSONObject object) throws Exception {
        connect();
        PreparedStatement statement = connection.prepareStatement("select a.id as rule_id, a.name, a.status, c.id as composite_id, c.table1, c.column1, c.value1, c.value2 from businessrule a left join businessrule_composite b on a.id = b.rule_id left join attributerange c on b.arr_id = c.id where b.arr_id is not null and a.database_id = ?");
        statement.setInt(1, object.getInt("database_id"));
        ResultSet s = statement.executeQuery();
        JSONObject output = Util.ResultSetToJSONArray(s, "arr");
        disconnect();
        return output;
    }

    @Override
    public JSONObject get(JSONObject object) throws Exception {
        connect();
        PreparedStatement statement = connection.prepareStatement("select a.id as rule_id, a.name, a.status, c.id as composite_id, c.table1, c.column1, c.value1, c.value2 from businessrule a left join businessrule_composite b on a.id = b.rule_id left join attributerange c on b.arr_id = c.id where b.arr_id is not null and a.id = ?");
        statement.setInt(1, object.getInt("id"));
        ResultSet s = statement.executeQuery();
        JSONObject output = Util.ResultSetToJSONObject(s, "arr");
        disconnect();
        return output;
    }

    @Override
    public void define(JSONObject object) throws Exception {

        int rule_id = getId("businessRule");
        int composite_id = getId("attributeRange");

        connect();
        PreparedStatement statement = connection.prepareStatement("insert into ATTRIBUTERANGE (ID, TABLE1, COLUMN1, VALUE1, VALUE2) values (?, ?, ?, ?, ?)");
        statement.setInt(1, composite_id);
        statement.setString(2, object.getString("table1"));
        statement.setString(3, object.getString("column1"));
        statement.setInt(4,object.getInt("value1"));
        statement.setInt(5,object.getInt("value2"));
        statement.execute();

        insertRule(object ,rule_id, composite_id);

        statement = connection.prepareStatement("insert into BUSINESSRULE_COMPOSITE (RULE_ID, ARR_ID) values (?,?)");
        statement.setInt(1,rule_id);
        statement.setInt(2,composite_id);
        statement.execute();

        disconnect();
    }

    @Override
    public void update(JSONObject object,int id, int comp_id) throws Exception {
        connect();

        PreparedStatement statement = connection.prepareStatement("update ATTRIBUTERANGE set TABLE1 = ?, COLUMN1 = ?, VALUE1 = ?, VALUE2 = ? where ID = ?");
        statement.setString(1, object.getString("table1"));
        statement.setString(2, object.getString("column1"));
        statement.setInt(3, object.getInt("value1"));
        statement.setInt(4, object.getInt("value2"));
        statement.setInt(5, comp_id);
        statement.execute();

        saveRule(object,id);

        disconnect();
    }

}
