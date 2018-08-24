package com.example.jersey.database.repository.DAO.tuple;

import com.example.jersey.database.repository.DAO.BusinessRuleDao;
import com.example.jersey.database.repository.DatabaseHelper_Repo;
import com.example.jersey.util.Util;
import org.json.JSONObject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TupleOtherDao extends DatabaseHelper_Repo implements BusinessRuleDao {

    @Override
    public JSONObject getAll(JSONObject object) throws Exception {
        connect();
        PreparedStatement statement = connection.prepareStatement("select a.id as rule_id, a.name, a.status, c.id as composite_id, c.table1, c.column1, c.column2, c.constraint from businessrule a left join businessrule_composite b on a.id = b.rule_id left join TUPLEOTHER c on b.tor_id = c.id where b.tor_id is not null and a.database_id = ?");
        statement.setInt(1, object.getInt("database_id"));
        ResultSet s = statement.executeQuery();
        JSONObject output = Util.ResultSetToJSONArray(s);
        disconnect();
        return output;
    }

    @Override
    public JSONObject get(JSONObject object) throws Exception {
        connect();
        PreparedStatement statement = connection.prepareStatement("select a.id as rule_id, a.name, a.status, c.id as composite_id, c.table1, c.column1, c.column2, c.constraint from businessrule a left join businessrule_composite b on a.id = b.rule_id left join TUPLEOTHER c on b.tor_id = c.id where b.tor_id is not null and a.id = ?");
        statement.setInt(1, object.getInt("id"));
        ResultSet s = statement.executeQuery();
        JSONObject output = Util.ResultSetToJSONObject(s);
        disconnect();
        return output;
    }

    @Override
    public void define(JSONObject object) throws Exception {
        int rule_id = getId("businessRule");
        int composite_id = getId("tupleOther");

        connect();
        PreparedStatement statement = connection.prepareStatement("insert into TUPLEOTHER (ID, TABLE1, TYPE, CODE) values (?, ?, ?, ?)");
        statement.setInt(1, composite_id);
        statement.setString(2, object.getString("table1"));
        statement.setString(3, object.getString("type"));
        statement.setString(4,object.getString("plSQL"));
        statement.execute();

        insertRule(object ,rule_id);

        statement = connection.prepareStatement("insert into BUSINESSRULE_COMPOSITE (RULE_ID, TOR_ID) values (?,?)");
        statement.setInt(1,rule_id);
        statement.setInt(2,composite_id);
        statement.execute();

        disconnect();
    }

    @Override
    public void update(JSONObject object) throws Exception {
        connect();

        PreparedStatement statement = connection.prepareStatement("update TUPLEOTHER set TABLE1 = ?, COLUMN1 = ?, COLUMN2 = ?, CONSTRAINT = ? where ID = ?");
        statement.setString(1, object.getString("table1"));
        statement.setString(2, object.getString("column1"));
        statement.setString(3, object.getString("column2"));
        statement.setString(4, object.getString("constraint"));
        statement.setInt(5, object.getInt("composite_id"));
        statement.execute();

        saveRule(object);

        disconnect();
    }

}
