package com.example.jersey.domainTest;

import com.example.jersey.domainTest.Composit.BusinessRuleComposite;
import org.json.JSONObject;

public class BusinessRule {

    int id;
    String name;
    String status;
    int database_id;

    BusinessRuleComposite composite;

    public BusinessRule(int database_id){
        this.status = "new";
        this.database_id = database_id;
    }

    public BusinessRule(int id, int database_id){
        this.id = id;
        this.status = "new";
        this.database_id = database_id;
    }

    public String getName(){
        if (name == null) generateName();
        return name;
    }

    private void generateName(){
        //TODO get number for rule (temporarily 1)
        name = composite.getName() + 1;
    }

    public void addComposite(BusinessRuleComposite composite){
        this.composite = composite;
    }

    public JSONObject getRule(){
        JSONObject object = composite.getComposite();
        object.put("base_id", id);
        object.put("name", getName());
        object.put("status", status);
        object.put("database_id", database_id);
        return object;
    }


    public void validate() {
        composite.validate();
    }
}
