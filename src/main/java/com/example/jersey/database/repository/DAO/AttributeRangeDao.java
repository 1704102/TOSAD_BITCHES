package com.example.jersey.database.repository.DAO;

import com.example.jersey.database.repository.DatabaseHelper_Repo;
import com.mysql.cj.protocol.Resultset;
import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class AttributeRangeDao extends DatabaseHelper_Repo implements BusinessRuleDao{
    @Override
    public JSONObject getAll() {
        connect();
        JSONObject output = new JSONObject();
        JSONArray array = new JSONArray();
        try {
            PreparedStatement statement = connection.prepareStatement("select a.id as rule_id, a.name, a.status, c.id as composite_id, c.table1, c.column1, c.value1, c.value2 from businessrule a left join businessrule_composite b on a.id = b.rule_id left join attributerange c on b.arr_id = c.id where b.arr_id is not null");
            ResultSet s = statement.executeQuery();
            ResultSetMetaData rsmd = s.getMetaData();
            while (s.next()){
                JSONObject rule = new JSONObject();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    rule.put(rsmd.getColumnName(i), s.getString(i));
                }
                array.put(rule);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        disconnect();
        output.put("rules", array);
        return output;
    }

    @Override
    public JSONObject get(JSONObject object) {
        connect();
        JSONObject output = new JSONObject();
        try {
            PreparedStatement statement = connection.prepareStatement("select a.id as rule_id, a.name, a.status, c.id as composite_id, c.table1, c.column1, c.value1, c.value2 from businessrule a left join businessrule_composite b on a.id = b.rule_id left join attributerange c on b.arr_id = c.id where b.arr_id is not null and a.id = ?");
            statement.setInt(1, object.getInt("id"));
            ResultSet s = statement.executeQuery();
            ResultSetMetaData rsmd = s.getMetaData();
            while (s.next()){
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    output.put(rsmd.getColumnName(i), s.getString(i));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        disconnect();
        return output;
    }

    @Override
    public void define(JSONObject object) {

        int rule_id = getRuleInitId();
        int composite_id = getInitId();

        try {
            connect();
            PreparedStatement statement = connection.prepareStatement("insert into ATTRIBUTERANGE (ID, TABLE1, COLUMN1, VALUE1, VALUE2) values (?, ?, ?, ?, ?)");
            statement.setInt(1, composite_id);
            statement.setString(2, object.getString("table"));
            statement.setString(3, object.getString("column"));
            statement.setInt(4,object.getInt("valueLow"));
            statement.setInt(5,object.getInt("valueHigh"));
            statement.execute();

            statement = connection.prepareStatement("insert into BUSINESSRULE (ID, NAME, STATUS) values (?, ?, ?)");
            statement.setInt(1, rule_id);
            statement.setString(2, object.getString("name"));
            statement.setString(3, object.getString("status"));
            statement.execute();


            statement = connection.prepareStatement("insert into BUSINESSRULE_COMPOSITE (RULE_ID, ARR_ID) values (?,?)");
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
        try {
            connect();
            PreparedStatement statement = connection.prepareStatement("update ATTRIBUTERANGE set TABLE1 = ?, COLUMN1 = ?, VALUE1 = ?, VALUE2 = ? where ID = ?");
            statement.setString(1, object.getString("table"));
            statement.setString(2, object.getString("column"));
            statement.setInt(3, object.getInt("value1"));
            statement.setInt(4, object.getInt("value2"));
            statement.setInt(5, object.getInt("composite_id"));
            statement.execute();

            statement = connection.prepareStatement("update BUSINESSRULE set NAME = ?, STATUS = ? where id = ?");
            statement.setString(1, object.getString("name"));
            statement.setString(2, object.getString("status"));
            statement.setInt(3, object.getInt("rule_id"));
            statement.execute();

            disconnect();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(JSONObject object) {
        connect();
        try {
            PreparedStatement statement = connection.prepareStatement("delete from businessrule where id = ?");
            statement.setInt(1, object.getInt("rule_id"));
            statement.execute();

            statement = connection.prepareStatement("delete from businessrule_composite where rule_id = ?");
            statement.setInt(1, object.getInt("rule_id"));
            statement.execute();

            statement = connection.prepareStatement("delete from attributerange where id = ?");
            statement.setInt(1, object.getInt("composite_id"));
            statement.execute();
        }catch (Exception e) {
            e.printStackTrace();
        }
        disconnect();
    }

    @Override
    public int getInitId() {
        connect();
        int id = 0;
        try {
            PreparedStatement statement = connection.prepareStatement("select max(id) as max from attributerange");
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
