package com.example.jersey.database.repository.DAO.attribute;

import com.example.jersey.database.repository.DAO.BusinessRuleDao;
import com.example.jersey.database.repository.DatabaseHelper_Repo;
<<<<<<< HEAD:src/main/java/com/example/jersey/database/repository/DAO/AttributeCompareDao.java
<<<<<<< HEAD
=======
import com.example.jersey.util.Util;
>>>>>>> origin/martijndev
=======
>>>>>>> development:src/main/java/com/example/jersey/database/repository/DAO/attribute/AttributeCompareDao.java
import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.PreparedStatement;
<<<<<<< HEAD:src/main/java/com/example/jersey/database/repository/DAO/AttributeCompareDao.java
<<<<<<< HEAD
=======
import java.sql.ResultSet;
>>>>>>> origin/martijndev
=======
>>>>>>> development:src/main/java/com/example/jersey/database/repository/DAO/attribute/AttributeCompareDao.java
import java.sql.SQLException;

public class AttributeCompareDao extends DatabaseHelper_Repo implements BusinessRuleDao {
    @Override
<<<<<<< HEAD:src/main/java/com/example/jersey/database/repository/DAO/AttributeCompareDao.java
<<<<<<< HEAD
=======
<<<<<<< HEAD:src/main/java/com/example/jersey/database/repository/DAO/AttributeCompareDao.java
>>>>>>> development:src/main/java/com/example/jersey/database/repository/DAO/attribute/AttributeCompareDao.java
    public JSONArray getAll(JSONObject object) {
        return null;
    }

    @Override
    public JSONObject get(JSONObject object) {
        return null;
<<<<<<< HEAD:src/main/java/com/example/jersey/database/repository/DAO/AttributeCompareDao.java
=======
    }

    @Override
    public void define(JSONObject object) {
>>>>>>> development:src/main/java/com/example/jersey/database/repository/DAO/attribute/AttributeCompareDao.java
=======
    public JSONObject getAll(JSONObject object) throws Exception{
        connect();
        PreparedStatement statement = connection.prepareStatement("select a.id as rule_id, a.name, a.status, c.id as composite_id, c.table1, c.column1, c.value1, c.operator from businessrule a left join businessrule_composite b on a.id = b.rule_id left join attributecompare c on b.acr_id = c.id where b.acr_id is not null and a.database_id = ?");
        statement.setInt(1, object.getInt("database_id"));
        ResultSet s = statement.executeQuery();
        JSONObject output = Util.ResultSetToJSONArray(s, "acr");
        disconnect();
        return output;
    }

    @Override
    public JSONObject get(JSONObject object) throws Exception {
        connect();
        PreparedStatement statement = connection.prepareStatement("select a.id as rule_id, a.name, a.status, c.id as composite_id, c.table1, c.column1, c.value1, c.operator from businessrule a left join businessrule_composite b on a.id = b.rule_id left join attributecompare c on b.acr_id = c.id where b.acr_id is not null and a.id = ?");
        statement.setInt(1, object.getInt("id"));
        ResultSet s = statement.executeQuery();
        JSONObject output = Util.ResultSetToJSONObject(s, "acr");
        disconnect();
        return output;
>>>>>>> origin/martijndev
    }

    @Override
<<<<<<< HEAD:src/main/java/com/example/jersey/database/repository/DAO/AttributeCompareDao.java
    public void define(JSONObject object) {
<<<<<<< HEAD
        try {
            connect();
            PreparedStatement statement = connection.prepareStatement("insert into ATTRIBUTECOMPARE (ID, TABLE1, COLUMN1, VALUE1, OPERATOR) values (?, ?, ?, ?, ?)");
            statement.setInt(1,1);
            statement.setString(2, object.getString("table"));
            statement.setString(3, object.getString("column"));
            statement.setInt(4,object.getInt("value"));
            statement.setString(5,object.getString("operator"));
            statement.execute();

            statement = connection.prepareStatement("insert into BUSINESSRULE (ID, NAME, STATUS) values (?, ?, ?)");
            statement.setInt(1, 1);
            statement.setString(2, object.getString("name"));
            statement.setString(3, object.getString("status"));


            statement = connection.prepareStatement("insert into BUSINESSRULE_COMPONENT (BUSINESSRULE_ID, ATTRIBUTECOMPARE_ID) values (?,?)");
            statement.setInt(1,1);
            statement.setInt(2,1);
=======
=======
    public void define(JSONObject object) throws Exception{
>>>>>>> development:src/main/java/com/example/jersey/database/repository/DAO/attribute/AttributeCompareDao.java

        int rule_id = getId("businessRule");
        int composite_id = getId("attributeCompare");

>>>>>>> origin/martijndev:src/main/java/com/example/jersey/database/repository/DAO/attribute/AttributeCompareDao.java
        try {
            connect();
            PreparedStatement statement = connection.prepareStatement("insert into ATTRIBUTECOMPARE (ID, TABLE1, COLUMN1, VALUE1, OPERATOR) values (?, ?, ?, ?, ?)");
            statement.setInt(1,1);
            statement.setString(2, object.getString("table"));
            statement.setString(3, object.getString("column"));
            statement.setInt(4,object.getInt("value"));
            statement.setString(5,object.getString("operator"));
            statement.execute();

<<<<<<< HEAD:src/main/java/com/example/jersey/database/repository/DAO/AttributeCompareDao.java
            statement = connection.prepareStatement("insert into BUSINESSRULE (ID, NAME, STATUS) values (?, ?, ?)");
            statement.setInt(1, 1);
            statement.setString(2, object.getString("name"));
            statement.setString(3, object.getString("status"));

=======
            insertRule(object ,rule_id, composite_id);
>>>>>>> origin/martijndev:src/main/java/com/example/jersey/database/repository/DAO/attribute/AttributeCompareDao.java

<<<<<<< HEAD:src/main/java/com/example/jersey/database/repository/DAO/AttributeCompareDao.java
            statement = connection.prepareStatement("insert into BUSINESSRULE_COMPOSITE (RULE_ID, ACR_ID) values (?,?)");
            statement.setInt(1,rule_id);
            statement.setInt(2,composite_id);
>>>>>>> origin/martijndev
=======
            statement = connection.prepareStatement("insert into BUSINESSRULE_COMPONENT (BUSINESSRULE_ID, ATTRIBUTECOMPARE_ID) values (?,?)");
            statement.setInt(1,1);
            statement.setInt(2,1);
>>>>>>> development:src/main/java/com/example/jersey/database/repository/DAO/attribute/AttributeCompareDao.java
            statement.execute();
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
<<<<<<< HEAD:src/main/java/com/example/jersey/database/repository/DAO/AttributeCompareDao.java
<<<<<<< HEAD
    public void update(JSONObject object) {

    }

    @Override
    public void delete(JSONObject object) {

=======
<<<<<<< HEAD:src/main/java/com/example/jersey/database/repository/DAO/AttributeCompareDao.java
    public void update(JSONObject object) {
>>>>>>> development:src/main/java/com/example/jersey/database/repository/DAO/attribute/AttributeCompareDao.java
=======
    public void update(JSONObject object) throws Exception {
        connect();

        PreparedStatement statement = connection.prepareStatement("update ATTRIBUTECOMPARE set TABLE1 = ?, COLUMN1 = ?, VALUE1 = ?, OPERATOR = ? where ID = ?");
        statement.setString(1, object.getString("table1"));
        statement.setString(2, object.getString("column1"));
        statement.setInt(3, object.getInt("value1"));
        statement.setString(4, object.getString("operator"));
        statement.setInt(5, object.getInt("composite_id"));
        statement.execute();

       saveRule(object);
>>>>>>> origin/martijndev:src/main/java/com/example/jersey/database/repository/DAO/attribute/AttributeCompareDao.java

    }

<<<<<<< HEAD:src/main/java/com/example/jersey/database/repository/DAO/AttributeCompareDao.java
    @Override
    public void delete(JSONObject object) {

<<<<<<< HEAD:src/main/java/com/example/jersey/database/repository/DAO/AttributeCompareDao.java
        PreparedStatement statement = connection.prepareStatement("delete from businessrule where id = ?");
        statement.setInt(1, object.getInt("rule_id"));
        statement.execute();

        statement = connection.prepareStatement("delete from businessrule_composite where rule_id = ?");
        statement.setInt(1, object.getInt("rule_id"));
        statement.execute();

        statement = connection.prepareStatement("delete from attributecompare where id = ?");
        statement.setInt(1, object.getInt("composite_id"));
        statement.execute();

        disconnect();
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
>>>>>>> origin/martijndev
=======
>>>>>>> development:src/main/java/com/example/jersey/database/repository/DAO/attribute/AttributeCompareDao.java
    }
=======
>>>>>>> origin/martijndev:src/main/java/com/example/jersey/database/repository/DAO/attribute/AttributeCompareDao.java
}
