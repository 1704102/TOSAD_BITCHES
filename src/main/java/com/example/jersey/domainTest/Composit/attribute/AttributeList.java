package com.example.jersey.domainTest.Composit.attribute;

import com.example.jersey.domainTest.Composit.BusinessRuleComposite;
import org.json.JSONArray;
import org.json.JSONObject;

public class AttributeList implements BusinessRuleComposite {

    private int id;
    private String table;
    private String column;

    private JSONArray list;

    public AttributeList(int id, String table, String column, JSONArray list) {
        this.id = id;
        this.table = table;
        this.column = column;
        this.list = list;
    }

    public AttributeList(String table, String column, JSONArray list) {
        this.table = table;
        this.column = column;
        this.list = list;

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

        JSONObject object = new JSONObject();
        object.put("id", id);
        object.put("table1", table);
        object.put("column1", column);
        object.put("list", list);
        return object;
    }
}
