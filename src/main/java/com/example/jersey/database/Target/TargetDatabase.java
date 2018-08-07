package com.example.jersey.database.Target;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class TargetDatabase extends DatabaseHelper_Target {

   public void getTables(){

   }

   public void getColumns(){

   }

   public void getForeignKeys(){
      connect();
      try {
         PreparedStatement statement = connection.prepareStatement("select * from all_constraints where Constraint_type=? and owner = ?");
         statement.setString(1, "R");
         statement.setString(2, "TOSAD_2017_HER_TEAM1_TARGET");
         ResultSet s = statement.executeQuery();
         while (s.next()){
            System.out.println(s.getString("TABLE_NAME"));
         }

      }catch (Exception e){

      }
      disconnect();
   }
}
