package com.example.jersey.domainTest.Composit.tuple;

import com.example.jersey.domainTest.Composit.BusinessRuleComposite;
import com.example.jersey.domainTest.Composit.Elements.Constraint;
import org.json.JSONObject;

public class TupleOther implements BusinessRuleComposite {

    private int id;

    private String table;
    private String columnOne;
    private String columnTwo;
    private String constraint;

    public TupleOther(String table, String columnOne, String columnTwo, String constraint) {
        this.table = table;
        this.columnOne = columnOne;
        this.columnTwo = columnTwo;
        this.constraint = constraint;

    }


    @Override
    public String getName() {
        return table + "_CNS_TOR";
    }

    @Override
    public boolean validate() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public JSONObject getComposite() {
        JSONObject object = new JSONObject();
        object.put("id", id);
        object.put("table1", table);
        object.put("column1", columnOne);
        object.put("column2", columnTwo);
        object.put("constraint", constraint);
        return object;
    }

}
