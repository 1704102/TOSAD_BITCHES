package com.example.jersey.database.Target;

import oracle.jdbc.proxy.annotation.Pre;
import org.json.JSONObject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class GenerateDatabase extends DatabaseHelper_Target {

   public void generateBusinessRule(JSONObject object) throws Exception{
      String type = object.getString("name").split("_")[2];
      switch (type){
         case "ARR" : generateAttributeRangeRule(object); break;
         case "ACR" : generateAttributeCompareRule(object); break;
         case "ALR" : generateAttributeListRule(object); break;
         case "AOR" : generateAttributeOtherRule(object); break;
         case "TCR" : generateTupleCompareRule(object); break;
         case "TOR" : break;
         case "IECR" : break;
         case "EOR" : break;
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

   public void generateAttributeOtherRule(JSONObject object) throws  Exception{
      connect();

      PreparedStatement statement = connection.prepareStatement("alter table " + object.getString("table1") + " add constraint " + object.getString("name") + " " + object.getString("plSQL") + " ENABLE NOVALIDATE");
      statement.execute();

      disconnect();
   }

   public void generateTupleCompareRule(JSONObject object) throws Exception{
      connect();

      PreparedStatement statement = connection.prepareStatement("alter table " + object.getString("table1") + " add constraint " + object.getString("name") + " check(" + object.getString("column1") + object.getString("operator") + object.getString("column2") +") ENABLE NOVALIDATE");
      statement.execute();

      disconnect();
   }
}
