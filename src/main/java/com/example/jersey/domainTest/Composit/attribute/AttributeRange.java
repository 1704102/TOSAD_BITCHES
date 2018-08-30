package com.example.jersey.domainTest.Composit.attribute;

import com.example.jersey.domainTest.Composit.BusinessRuleComposite;
import org.json.JSONObject;

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
        object.put("table", table);
        object.put("column", column);
        object.put("valueLow", valueLow);
        object.put("valueHigh", valueHigh);
        return object;
    }

}
