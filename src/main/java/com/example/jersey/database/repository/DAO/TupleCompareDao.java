package com.example.jersey.database.repository.DAO;

import com.example.jersey.database.repository.DatabaseHelper_Repo;
import com.example.jersey.util.Util;
import org.json.JSONObject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TupleCompareDao extends DatabaseHelper_Repo implements BusinessRuleDao{
    @Override
    public JSONObject getAll(JSONObject object) throws Exception {
        connect();
        PreparedStatement statement = connection.prepareStatement("select a.id as rule_id, a.name, a.status, c.id as composite_id, c.table1, c.column1, c.column2, c.operator from businessrule a left join businessrule_composite b on a.id = b.rule_id left join TUPLECOMPARE c on b.tcr_id = c.id where b.tcr_id is not null and a.database_id = ?");
        statement.setInt(1, object.getInt("database_id"));
        ResultSet s = statement.executeQuery();
        JSONObject output = Util.ResultSetToJSONArray(s);
        disconnect();
        return output;
    }

    @Override
    public JSONObject get(JSONObject object) throws Exception {
        connect();
        PreparedStatement statement = connection.prepareStatement("select a.id as rule_id, a.name, a.status, c.id as composite_id, c.table1, c.column1, c.column2, c.operator from businessrule a left join businessrule_composite b on a.id = b.rule_id left join TUPLECOMPARE c on b.tcr_id = c.id where b.tcr_id is not null and a.id = ?");
        statement.setInt(1, object.getInt("id"));
        ResultSet s = statement.executeQuery();
        JSONObject output = Util.ResultSetToJSONObject(s);
        disconnect();
        return output;
    }

    @Override
    public void define(JSONObject object) throws Exception {
        int rule_id = getRuleInitId();
        int composite_id = getInitId();

        connect();
        PreparedStatement statement = connection.prepareStatement("insert into TUPLECOMPARE (ID, TABLE1, COLUMN1, COLUMN2, OPERATOR) values (?, ?, ?, ?, ?)");
        statement.setInt(1, composite_id);
        statement.setString(2, object.getString("table1"));
        statement.setString(3, object.getString("column1"));
        statement.setString(4,object.getString("column2"));
        statement.setString(5,object.getString("operator"));
        statement.execute();

        statement = connection.prepareStatement("insert into BUSINESSRULE (ID, NAME, STATUS, DATABASE_ID) values (?, ?, ?, ?)");
        statement.setInt(1, rule_id);
        statement.setString(2, object.getString("name"));
        statement.setString(3, object.getString("status"));
        statement.setInt(4, object.getInt("database_id"));
        statement.execute();


        statement = connection.prepareStatement("insert into BUSINESSRULE_COMPOSITE (RULE_ID, TCR_ID) values (?,?)");
        statement.setInt(1,rule_id);
        statement.setInt(2,composite_id);
        statement.execute();

        disconnect();
    }

    @Override
    public void update(JSONObject object) throws Exception {
        connect();

        PreparedStatement statement = connection.prepareStatement("update TUPLECOMPARE set TABLE1 = ?, COLUMN1 = ?, COLUMN2 = ?, OPERATOR = ? where ID = ?");
        statement.setString(1, object.getString("table1"));
        statement.setString(2, object.getString("column1"));
        statement.setString(3, object.getString("column2"));
        statement.setString(4, object.getString("operator"));
        statement.setInt(5, object.getInt("composite_id"));
        statement.execute();

        statement = connection.prepareStatement("update BUSINESSRULE set NAME = ?, STATUS = ? where id = ?");
        statement.setString(1, object.getString("name"));
        statement.setString(2, object.getString("status"));
        statement.setInt(3, object.getInt("rule_id"));
        statement.execute();

        disconnect();
    }

    @Override
    public void delete(JSONObject object) throws Exception {
        connect();

        PreparedStatement statement = connection.prepareStatement("delete from businessrule where id = ?");
        statement.setInt(1, object.getInt("rule_id"));
        statement.execute();

        statement = connection.prepareStatement("delete from businessrule_composite where rule_id = ?");
        statement.setInt(1, object.getInt("rule_id"));
        statement.execute();

        statement = connection.prepareStatement("delete from TUPLECOMPARE where id = ?");
        statement.setInt(1, object.getInt("composite_id"));
        statement.execute();

        disconnect();
    }

    @Override
    public int getInitId() throws Exception {
        connect();

        int id = 0;

        PreparedStatement statement = connection.prepareStatement("select max(id) as max from TUPLECOMPARE");
        ResultSet s = statement.executeQuery();
        while (s.next()){
            id = s.getInt("max");
        }

        disconnect();

        if (id == 0){
            return 1;
        }
        return id + 1;
    }
}
