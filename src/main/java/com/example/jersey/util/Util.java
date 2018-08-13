package com.example.jersey.util;

import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class Util {

    public static JSONObject ResultSetToJSONArray(ResultSet s) throws Exception{
        JSONArray array = new JSONArray();
        ResultSetMetaData rsmd = s.getMetaData();
        while (s.next()){
            JSONObject object = new JSONObject();
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                if (rsmd.getColumnName(i).equals("LIST")){
                    JSONArray array1 = new JSONArray(s.getString(i).split(";"));
                    object.put("value1", array1);
                }else {
                    object.put(rsmd.getColumnName(i), s.getString(i));
                }
            }
            array.put(object);
        }
        return new JSONObject(){{put("rules", array);}};
    }

    public static JSONObject ResultSetToJSONObject(ResultSet s) throws Exception{
        JSONObject object = new JSONObject();
        ResultSetMetaData rsmd = s.getMetaData();
        while (s.next()){
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                if (rsmd.getColumnName(i).equals("LIST")){
                    JSONArray array1 = new JSONArray(s.getString(i).split(";"));
                    object.put("value1", array1);
                }else {
                    object.put(rsmd.getColumnName(i), s.getString(i));
                }
            }
        }
        return object;
    }
}
