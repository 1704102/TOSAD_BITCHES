package com.example.jersey.domainTest.Composit;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;

public class AttributeRange implements BusinessRuleComposite {

    private int id;
    private String table;
    private String column;

    private int valueLow;
    private int valueHigh;

    public AttributeRange(int id, String table, String column, int valueLow, int valueHigh) {
        this.id = id;
        this.table = table;
        this.column = column;
        this.valueLow = valueLow;
        this.valueHigh = valueHigh;
    }

    public AttributeRange(String table, String column, int valueLow, int valueHigh) {
        this.table = table;
        this.column = column;
        this.valueLow = valueLow;
        this.valueHigh = valueHigh;
    }

    @Override
    public String getRuleCode(String name) {
        return "alter table " + table + " add constraint " + name + " check(" + column + " between " + valueLow + " and " + valueHigh + ") ENABLE NOVALIDATE";
    }

    @Override
    public String getName() {
        return table + "_CNS_ARR_";
    }

    @Override
    public boolean validate() {
        if (valueLow > valueHigh) return false;
        if (valueHigh < valueLow) return false;
        if (valueLow == valueHigh) return false;
        return true;
    }

    @Override
    public JSONObject getComposite() {
        JSONObject object = new JSONObject();
        object.put("id", id);
<<<<<<< HEAD
        object.put("table", table);
        object.put("column", column);
        object.put("valueLow", valueLow);
        object.put("valueHigh", valueHigh);
=======
        object.put("table1", table);
        object.put("column1", column);
        object.put("value1", valueLow);
        object.put("value2", valueHigh);
>>>>>>> origin/martijndev
        return object;
    }

}
