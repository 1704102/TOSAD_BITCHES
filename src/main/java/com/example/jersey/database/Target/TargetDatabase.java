package com.example.jersey.database.Target;

import oracle.jdbc.proxy.annotation.Pre;
import org.json.JSONObject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class TargetDatabase extends DatabaseHelper_Target {

   public void activateConstraint(JSONObject object) throws Exception{
      connect();

      PreparedStatement statement = connection.prepareStatement("alter table ? DISABLE constraint ?");
      statement.setString(1, object.getString("table1"));
      statement.setString(2, object.getString("name"));

      disconnect();
   }

   public void deactivateConstraint(JSONObject object) throws Exception{
      connect();

      PreparedStatement statement = connection.prepareStatement("alter table ? ENABLE constraint ?");
      statement.setString(1, object.getString("table1"));
      statement.setString(2, object.getString("name"));

      disconnect();
   }

   public void generateBusinessRule(JSONObject object) throws Exception{
      String type = object.getString("name").split("_")[2];
      switch (type){
         case "ARR" : generateAttributeRangeRule(object); break;
         case "ACR" : generateAttributeCompareRule(object); break;
         case "ALR" : generateAttributeListRule(object); break;
         case "TCR" : generateTupleCompareRule(object); break;
      }
   }

   public void generateAttributeRangeRule(JSONObject object) throws Exception{
      connect();

      PreparedStatement statement = connection.prepareStatement("alter table " + object.getString("table1") + " add constraint "+ object.getString("name") +" check(" + object.getString("column1") + " between ? and ?) ENABLE NOVALIDATE");
      statement.setInt(1, object.getInt("value1"));
      statement.setInt(2, object.getInt("value2"));
      statement.execute();

      disconnect();
   }

   public void generateAttributeCompareRule(JSONObject object) throws Exception{
      connect();

      PreparedStatement statement = connection.prepareStatement("alter table " + object.getString("table1") + " add constraint " + object.getString("name") + " check(" + object.getString("column1") + object.getString("operator") + object.getInt("value1") +") ENABLE NOVALIDATE");
      statement.execute();

      disconnect();
   }

   public void generateAttributeListRule(JSONObject object) throws Exception{
      connect();

      StringBuilder list = new StringBuilder();
      object.getJSONArray("list").forEach(e->{
         list.append("'" +e + "',");
      });
      list.deleteCharAt(list.length() - 1);

      PreparedStatement statement = connection.prepareStatement("alter table " + object.getString("table1") + " add constraint " + object.getString("name") + " check(" + object.getString("column1") + " in (" + list.toString() + ")) ENABLE NOVALIDATE");
      statement.execute();

      disconnect();
   }

   public void generateTupleCompareRule(JSONObject object) throws Exception{
      connect();

      PreparedStatement statement = connection.prepareStatement("alter table " + object.getString("table1") + " add constraint " + object.getString("name") + " check(" + object.getString("column1") + object.getString("operator") + object.getString("column2") +") ENABLE NOVALIDATE");
      statement.execute();

      disconnect();
   }

   public void deleteConstraint(JSONObject object) throws Exception{
      connect();
      PreparedStatement statement = connection.prepareStatement("ALTER TABLE " + object.getString("table1") + " DROP CONSTRAINt " + object.getString("name"));
      statement.execute();
      disconnect();
   }
}
