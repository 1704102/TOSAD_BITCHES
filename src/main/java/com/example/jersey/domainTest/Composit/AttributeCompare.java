package com.example.jersey.domainTest.Composit;

import com.example.jersey.domainTest.Composit.Elements.Operator;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;

public class AttributeCompare implements BusinessRuleComposite{

    private int id;

    String table;
    private String column;
    private int value;
    private Operator operator;

    public AttributeCompare(int id, String table, String column, int value, Operator operator) {
        this.id = id;
        this.table = table;
        this.column = column;
        this.value = value;
        this.operator = operator;
    }

    public AttributeCompare(String table, String column, int value, Operator operator) {
        this.table = table;
        this.column = column;
        this.value = value;
        this.operator = operator;
    }

    @Override
    public String getRuleCode(String name) {
        return "alter table " + table +  " add constraint " + name + " check(" + column + " " + operator.getValue() + " " + value + ") ENABLE NOVALIDATE";
    }

    @Override
    public String getName() {
        return table + "_CNS_ACR_";
    }

    @Override
    public boolean validate(){
        if (!operator.validate()) return false;
        return true;
    }

    @Override
    public JSONObject getComposite() {
        JSONObject object = new JSONObject();
        object.put("id", id);
        object.put("table1", table);
        object.put("column1", column);
        object.put("value1", value);
        object.put("operator", operator.getValue());
        return object;
    }

}
