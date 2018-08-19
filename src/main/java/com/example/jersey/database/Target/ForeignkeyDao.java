package com.example.jersey.database.Target;

import com.example.jersey.database.Target.DatabaseHelper_Target;
import java.sql.*;
import java.util.ArrayList;

public class ForeignkeyDao extends DatabaseHelper_Target {

    public ArrayList getforeignkeys(){
        System.out.println("test1");
        ArrayList<String> array= new ArrayList<>();
        ArrayList<ArrayList<String>> array2= new ArrayList<>();

        try{
            Statement stmt = null;
            String sql="SELECT UC.R_CONSTRAINT_NAME FROM USER_CONSTRAINTS  UC,USER_CONS_COLUMNS UCC WHERE UC.R_CONSTRAINT_NAME = UCC.CONSTRAINT_NAME AND UC.CONSTRAINT_TYPE = 'R'";
            String s= "hello1";
            connect();
            stmt= connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                s = rs.getString("R_CONSTRAINT_NAME");
                array.add(s);
            }
            System.out.println(array);

            for(String f: array){
                System.out.println(f);
                ArrayList<String> objectcollect= new ArrayList<>();



                Statement stmt3 = null;
                System.out.println("now starting sql 3");
                String sql3= "SELECT a.table_name table_name, a.column_name column_name,c_pk.table_name table_name2 " +
                        "FROM all_cons_columns a \n" +
                        "JOIN all_constraints c ON a.owner = c.owner\n" +
                        "AND a.constraint_name = c.constraint_name\n" +
                        "JOIN all_constraints c_pk ON c.r_owner = c_pk.owner\n" +
                        "AND c.r_constraint_name = c_pk.constraint_name\n" +
                        "WHERE c.constraint_type = 'R'\n" +
                        "and c_pk.constraint_name= '"+f+"'";


                stmt3= connection.createStatement();
                ResultSet rs3 = stmt3.executeQuery(sql3);
                while (rs3.next()) {
                    String table2 = rs3.getString("TABLE_NAME");
                    String column2 = rs3.getString("COLUMN_NAME");
                    String table1 = rs3.getString("table_name2");
                    objectcollect.add(table2);
                    objectcollect.add(column2);
                    objectcollect.add(table1);
                    System.out.println(table2 + "  "  + column2 +"  " + table1);

                }
                Statement stmt2 = null;

                String sql2= "SELECT UCC.TABLE_NAME, UCC.COLUMN_NAME FROM USER_CONSTRAINTS  UC, USER_CONS_COLUMNS UCC WHERE UC.R_CONSTRAINT_NAME = UCC.CONSTRAINT_NAME AND UC.CONSTRAINT_TYPE = 'R' And UC.R_CONSTRAINT_NAME='SYS_C00275352'";
                System.out.println(sql2);
                stmt2= connection.createStatement();
                ResultSet rs2 = stmt.executeQuery(sql2);

                while (rs2.next()) {
                    String column1 = rs2.getString("COLUMN_NAME");
                    objectcollect.add(column1);
                    System.out.println(column1);
                }


                array2.add(objectcollect);
                System.out.println(objectcollect);
            }
            disconnect();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return array2;
    }


}
