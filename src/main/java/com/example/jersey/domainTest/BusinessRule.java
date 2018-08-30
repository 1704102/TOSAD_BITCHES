package com.example.jersey.domainTest;

import com.example.jersey.domainTest.Composit.BusinessRuleComposite;
import org.json.JSONObject;

public class BusinessRule {

    int id;
    String name;
    String status;

    BusinessRuleComposite composite;

    public BusinessRule(){
        this.status = "new";
    }

    public BusinessRule(int id){
        this.id = id;
        this.status = "new";
    }

    public String getName(){
        if (name == null) generateName();
        return name;
    }

    private void generateName(){
        name = composite.getName();
    }

    public void addComposite(BusinessRuleComposite composite){
        this.composite = composite;
    }

    public JSONObject getRule(){
        JSONObject object = composite.getComposite();
        object.put("base_id", id);
        object.put("name", getName());
        object.put("status", status);
        return object;
    }


    public void validate() {
        composite.validate();
    }
}
