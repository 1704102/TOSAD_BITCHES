package com.example.jersey.util;

import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class Util {

    public static JSONObject ResultSetToJSONArray(ResultSet s,String type) throws Exception{
        JSONArray array = new JSONArray();
        ResultSetMetaData rsmd = s.getMetaData();
        while (s.next()){
            JSONObject object = new JSONObject();
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                if (rsmd.getColumnName(i).equals("LIST")){
                    JSONArray array1 = new JSONArray(s.getString(i).split(";"));
                    object.put("value1", array1);
                }else {
                    switch (rsmd.getColumnType(i)){
                        case 2: object.put(rsmd.getColumnName(i).toLowerCase(), s.getInt(i)); break;
                        case 12: object.put(rsmd.getColumnName(i).toLowerCase(), s.getString(i)); break;
                    }
                }
            }
            object.put("type", type);
            array.put(object);
        }
        return new JSONObject(){{put("rules", array);}};
    }

    public static JSONObject ResultSetToJSONObject(ResultSet s, String type) throws Exception{
        JSONObject object = new JSONObject();
        ResultSetMetaData rsmd = s.getMetaData();
        while (s.next()){
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                if (rsmd.getColumnName(i).equals("LIST")){
                    JSONArray array1 = new JSONArray(s.getString(i).split(";"));
                    object.put("value1", array1);
                }else {
                    switch (rsmd.getColumnType(i)){
                        case 2: object.put(rsmd.getColumnName(i).toLowerCase(), s.getInt(i));break;
                        case 12: object.put(rsmd.getColumnName(i).toLowerCase(), s.getString(i));break;
                    }
                }
            }
        }
        object.put("type", type);
        return object;
    }
}
