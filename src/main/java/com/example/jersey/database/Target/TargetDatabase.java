package com.example.jersey.database.Target;

import com.example.jersey.domainTest.Composit.Elements.Chainforeignkeys;
import com.example.jersey.util.Util;
import com.sun.jersey.json.impl.provider.entity.JSONObjectProvider;
import oracle.jdbc.proxy.annotation.Pre;
import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class TargetDatabase extends DatabaseHelper_Target{

    private final String COLUMNSQUERY = "SELECT COLUMN_NAME FROM USER_TAB_COLUMNS where table_name = ?";
    private final String TABLESQUERY = "SELECT DISTINCT(TABLE_NAME) FROM USER_TAB_COLUMNS";

    public JSONObject getColumns(JSONObject object) throws Exception{
        connect();
        PreparedStatement statement = connection.prepareStatement(COLUMNSQUERY);
        statement.setString(1, object.getString("table"));
        JSONObject object1 = new JSONObject();
        JSONArray array = new JSONArray();
        ResultSet s = statement.executeQuery();
        while (s.next()){
            array.put(s.getString("COLUMN_NAME"));
        }
        disconnect();
        object1.put("columns", array);
        return object1;
    }

    public String interEntityRuleFk(String table1,String table2) throws Exception{
        TargetDatabaseFacade f = new TargetDatabaseFacade();
        ArrayList<ArrayList<String>> array=getForeignKeys();
        Chainforeignkeys fks = new Chainforeignkeys(array,table1,table2);
        String s = fks.getKeyChainSQL();
        String s1= fks.getFrom();
        return s;

    }

    public ArrayList<ArrayList<String>> getForeignKeys() throws Exception{

        ArrayList<String> array= new ArrayList<>();
        ArrayList<ArrayList<String>> array2= new ArrayList<>();

        String sql="SELECT UC.R_CONSTRAINT_NAME FROM USER_CONSTRAINTS  UC,USER_CONS_COLUMNS UCC WHERE UC.R_CONSTRAINT_NAME = UCC.CONSTRAINT_NAME AND UC.CONSTRAINT_TYPE = 'R'";

        connect();
        Statement stmt= connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            array.add(rs.getString("R_CONSTRAINT_NAME"));
        }

        stmt.close();

        for(String f: array){
            ArrayList<String> objectCollect= new ArrayList<>();

            String sql3= "SELECT a.table_name table_name, a.column_name column_name,c_pk.table_name table_name2 " +
                    "FROM all_cons_columns a \n" +
                    "JOIN all_constraints c ON a.owner = c.owner\n" +
                    "AND a.constraint_name = c.constraint_name\n" +
                    "JOIN all_constraints c_pk ON c.r_owner = c_pk.owner\n" +
                    "AND c.r_constraint_name = c_pk.constraint_name\n" +
                    "WHERE c.constraint_type = 'R'\n" +
                    "and c_pk.constraint_name= '"+f+"'";


            Statement stmt3= connection.createStatement();
            ResultSet rs3 = stmt3.executeQuery(sql3);
            while (rs3.next()) {
                objectCollect.add(rs3.getString("TABLE_NAME"));
                objectCollect.add(rs3.getString("COLUMN_NAME"));
                objectCollect.add(rs3.getString("table_name2"));
            }
            stmt3.close();

            String sql2= "SELECT UCC.TABLE_NAME, UCC.COLUMN_NAME FROM USER_CONSTRAINTS  UC, USER_CONS_COLUMNS UCC WHERE UC.R_CONSTRAINT_NAME = UCC.CONSTRAINT_NAME AND UC.CONSTRAINT_TYPE = 'R' And UC.R_CONSTRAINT_NAME='"+f+"'";
            Statement stmt2= connection.createStatement();
            ResultSet rs2 = stmt2.executeQuery(sql2);
            while (rs2.next()) {
                objectCollect.add(rs2.getString("COLUMN_NAME"));

            }
            array2.add(objectCollect);
            stmt2.close();
        }
        disconnect();

        return array2;
    }


}

