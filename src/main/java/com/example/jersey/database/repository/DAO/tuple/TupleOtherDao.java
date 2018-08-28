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
        PreparedStatement statement = connection.prepareStatement("select a.id as rule_id, a.name, a.status, c.id as composite_id, c.table1, c.type, c.PLSQL from businessrule a left join businessrule_composite b on a.id = b.rule_id left join TUPLEOTHER c on b.tor_id = c.id where b.tor_id is not null and a.database_id = ?");
        statement.setInt(1, object.getInt("database_id"));
        ResultSet s = statement.executeQuery();
        JSONObject output = Util.ResultSetToJSONArray(s);
        disconnect();
        return output;
    }

    @Override
    public JSONObject get(JSONObject object) throws Exception {
        connect();
        PreparedStatement statement = connection.prepareStatement("select a.id as rule_id, a.name, a.status, c.id as composite_id, c.table1, c.type, c.PLSQL from businessrule a left join businessrule_composite b on a.id = b.rule_id left join TUPLEOTHER c on b.tor_id = c.id where b.tor_id is not null and a.id = ?");
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
        PreparedStatement statement = connection.prepareStatement("insert into TUPLEOTHER (ID, TABLE1, TYPE, PLSQL) values (?, ?, ?, ?)");
        statement.setInt(1, composite_id);
        statement.setString(2, object.getString("table1"));
        statement.setString(3, object.getString("type"));
        statement.setString(4,object.getString("plSQL"));
        statement.execute();

        insertRule(object ,rule_id, composite_id);

        statement = connection.prepareStatement("insert into BUSINESSRULE_COMPOSITE (RULE_ID, TOR_ID) values (?,?)");
        statement.setInt(1,rule_id);
        statement.setInt(2,composite_id);
        statement.execute();

        disconnect();
    }

    @Override
    public void update(JSONObject object) throws Exception {
        connect();

        PreparedStatement statement = connection.prepareStatement("update TUPLEOTHER set TABLE1 = ?, TYPE = ?, PLSQL = ? where ID = ?");
        statement.setString(1, object.getString("table1"));
        statement.setString(2, object.getString("type"));
        statement.setString(3, object.getString("plSQL"));
        statement.setInt(4, object.getInt("composite_id"));
        statement.execute();

        saveRule(object);

        disconnect();
    }

}
