package com.example.jersey.database.Target;

import com.example.jersey.util.Util;
import com.sun.jersey.json.impl.provider.entity.JSONObjectProvider;
import oracle.jdbc.proxy.annotation.Pre;
import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

    public JSONObject getTables(JSONObject object) throws Exception{
        connect();
        PreparedStatement statement = connection.prepareStatement(TABLESQUERY);
        JSONObject object1 = new JSONObject();
        JSONArray array = new JSONArray();
        ResultSet s = statement.executeQuery();
        while (s.next()){
            array.put(s.getString("TABLE_NAME"));
        }
        disconnect();
        object1.put("tables", array);
        return object1;
    }
}
