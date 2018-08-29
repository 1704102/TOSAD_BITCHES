package com.example.jersey.database.Target;

import java.sql.*;
import java.util.ArrayList;

public class InterentityruleDAO extends DatabaseHelper_Target {

    public void makeRule(String table1, String table2, String column1, String column2, String operator, String brname,String foreignkeys){

        try {
            connect();
            String sql= "create or replace trigger "+brname+" " +"\n"+
                    "before insert or update on orders " +"\n"+
                    "for each row " +"\n"+
                    "declare " +"\n"+
                    "v_number number; " +"\n"+
                    "begin " +"\n"+
                    "select count("+table1+"."+column1+ ") into v_number " +"\n"
                    +foreignkeys+" and" +"\n"+
                    " :new."+column1+""+operator+""+table2+"."+column2+"; " +"\n"+
                    "if v_number > 0 then " +"\n"+
                    "RAISE_APPLICATION_ERROR(-200,'Breaking BRRULE'); " +"\n"+
                    "end if; " +"\n"+
                    "end;";
            connection.createStatement().execute(sql);
            System.out.println("succes");
            System.out.println(sql);
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
