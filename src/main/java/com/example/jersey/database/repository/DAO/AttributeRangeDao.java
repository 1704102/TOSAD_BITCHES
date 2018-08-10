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
    public JSONArray getAll(JSONObject object) {
        return null;
    }

    @Override
    public JSONObject get(JSONObject object) {
        connect();
        JSONObject output = new JSONObject();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from businessrule a left join businessrule_component b on a.id = b.businessrule_id left join attributerange c on b.attributerange_id = c.id where b.attributerange_id is not null and a.id = ?");
            statement.setInt(1, object.getInt("id"));
            ResultSet s = statement.executeQuery();
            ResultSetMetaData rsmd = s.getMetaData();
            while (s.next()){
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    output.put(rsmd.getColumnName(i), s.getString(i-1));
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
        try {
            connect();
            PreparedStatement statement = connection.prepareStatement("insert into ATTRIBUTERANGE (ID, TABLE1, COLUMN1, VALUE1, VALUE2) values (?, ?, ?, ?, ?)");
            statement.setInt(1,1);
            statement.setString(2, object.getString("table"));
            statement.setString(3, object.getString("column"));
            statement.setInt(4,object.getInt("valueLow"));
            statement.setInt(5,object.getInt("valueHigh"));
            statement.execute();

            statement = connection.prepareStatement("insert into BUSINESSRULE (ID, NAME, STATUS) values (?, ?, ?)");
            statement.setInt(1, 1);
            statement.setString(2, object.getString("name"));
            statement.setString(3, object.getString("status"));
            statement.execute();


            statement = connection.prepareStatement("insert into BUSINESSRULE_COMPONENT (BUSINESSRULE_ID, ATTRIBUTERANGE_ID) values (?,?)");
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
        try {
            connect();
            PreparedStatement statement = connection.prepareStatement("update ATTRIBUTERANGE set TABLE1 = ?, COLUMN1 = ?, VALUE1 = ?, VALUE2 = ? where ID = ?");
            statement.setString(1, object.getString("table"));
            statement.setString(2, object.getString("column"));
            statement.setInt(3, object.getInt("valueLow"));
            statement.setInt(4, object.getInt("valueHigh"));
            statement.setInt(5, object.getInt("id"));
            statement.execute();

            statement = connection.prepareStatement("update BUSINESSRULE set NAME = ?, STATUS = ? where id = ?");
            statement.setString(1, object.getString("name"));
            statement.setString(2, object.getString("status"));
            statement.setInt(3, object.getInt("base_id"));

            disconnect();
        }catch (Exception e){

        }
    }

    @Override
    public void delete(JSONObject object) {

    }
}
