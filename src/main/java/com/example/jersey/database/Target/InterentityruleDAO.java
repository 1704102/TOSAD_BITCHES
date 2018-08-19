package com.example.jersey.database.Target;
import com.example.jersey.database.Target.DatabaseHelper_Target;
import javafx.scene.chart.PieChart;

import java.sql.*;
import java.util.ArrayList;

public class InterentityruleDAO extends DatabaseHelper_Target {

    public void makeRule(String table1, String table2, String column1, String column2, String operator, String brname,String foreignkeys){
        String sql="create view "+brname+"view \n" +
                "as\n" +
                "select "+table1+"."+column1+", "+table2+"."+column2+"\n" +"from Orders,persons,products" + "where "+foreignkeys;
        String sql2 = "\n" +
                "Alter view "+brname+"view\n" +
                "add constraint"+brname+"warning\n" +
                "check ("+table1+"."+column1+operator+table2+"."+column2+")";
        }



}
