package com.example.jersey.domainTest.Composit;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class AttributeList implements BusinessRuleComposite{

    private int id;
    private String table;
    private String column;

    private ArrayList<String> list;

    public AttributeList(int id, String table, String column, ArrayList<String> list) {
        this.id = id;
        this.table = table;
        this.column = column;
        this.list = list;
    }

    public AttributeList(String table, String column, ArrayList<String> list) {
        this.table = table;
        this.column = column;
        this.list = list;
    }

    @Override
    public String getRuleCode(String name) {
        return null;
    }

    @Override
    public String getName() {
        return table + "_CNS_ALR_";
    }

    @Override
    public boolean validate() {
        return true;
    }

    @Override
    public JSONObject getComposite() {
        JSONArray array = new JSONArray("list");
        list.forEach(e->{
            array.put(e);
        });
        JSONObject object = new JSONObject();
        object.put("id", id);
        object.put("table", table);
        object.put("column", column);
        object.put("list", array);
        return object;
    }
}
