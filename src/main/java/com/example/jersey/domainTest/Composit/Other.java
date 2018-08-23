package com.example.jersey.domainTest.Composit;

import com.example.jersey.domainTest.Composit.BusinessRuleComposite;
import com.example.jersey.domainTest.Composit.Elements.Constraint;
import org.json.JSONObject;

public class Other implements BusinessRuleComposite {

    private int id;

    private String table;
    private Constraint constraint;

    public Other(String table, Constraint constraint) {
        this.table = table;
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
        JSONObject object = constraint.getConstraint();
        object.put("id", id);
        object.put("table1", table);
        return object;
    }

}
