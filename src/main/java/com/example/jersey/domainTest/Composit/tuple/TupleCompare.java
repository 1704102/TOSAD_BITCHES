package com.example.jersey.domainTest.Composit.tuple;

import com.example.jersey.domainTest.Composit.BusinessRuleComposite;
import com.example.jersey.domainTest.Composit.Elements.Operator;
import org.json.JSONObject;

public class TupleCompare implements BusinessRuleComposite {

    private int id;

    private String table;
    private String columnOne;
    private String columnTwo;
    private Operator operator;

    public TupleCompare(int id, String table, String columnOne, String columnTwo, Operator operator) {
        this.id = id;
        this.table = table;
        this.columnOne = columnOne;
        this.columnTwo = columnTwo;
        this.operator = operator;
    }

    public TupleCompare(String table, String columnOne, String columnTwo, Operator operator) {
        this.table = table;
        this.columnOne = columnOne;
        this.columnTwo = columnTwo;
        this.operator = operator;
    }

    @Override
    public String getName() {
        return table + "_CNS_TCR_";
    }

    @Override
    public boolean validate() {
        if(!operator.validate()) return false;
        return true;
    }

    @Override
    public JSONObject getComposite() {
        JSONObject object = new JSONObject();
        object.put("id", id);
        object.put("table1", table);
        object.put("column1", columnOne);
        object.put("column2", columnTwo);
        object.put("operator", operator.getValue());
        return object;
    }

}