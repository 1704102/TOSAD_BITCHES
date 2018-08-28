package com.example.jersey.domainTest.Composit.entity;

import com.example.jersey.domainTest.Composit.BusinessRuleComposite;
import com.example.jersey.domainTest.Composit.Elements.Constraint;
import org.json.JSONObject;

public class EntityOther implements BusinessRuleComposite {

    private int id;

    private String table;
    private Constraint constraint;

    public EntityOther(String table, Constraint constraint) {
        this.table = table;
        this.constraint = constraint;

    }


    @Override
    public String getName() {
        return table + "_CNS_EOR_";
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
