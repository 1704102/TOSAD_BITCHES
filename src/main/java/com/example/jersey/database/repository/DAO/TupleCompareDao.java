package com.example.jersey.database.repository.DAO;

import com.example.jersey.database.repository.DatabaseHelper_Repo;
import org.json.JSONObject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TupleCompareDao extends DatabaseHelper_Repo implements BusinessRuleDao{
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

    }

    @Override
    public void delete(JSONObject object) throws Exception {

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
