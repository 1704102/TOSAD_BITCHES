package com.example.jersey.domainTest;

import com.example.jersey.domainTest.Composit.BusinessRuleComposite;
import org.json.JSONObject;

public class BusinessRule {

    int id;
    String name;
    String status;
<<<<<<< HEAD
<<<<<<< HEAD

    BusinessRuleComposite composite;

    public BusinessRule(){
        this.status = "new";
    }

    public BusinessRule(int id){
        this.id = id;
        this.status = "new";
=======
    int database_id;
=======
>>>>>>> development

    BusinessRuleComposite composite;

    public BusinessRule(){
        this.status = "new";
    }

    public BusinessRule(int id){
        this.id = id;
        this.status = "new";
<<<<<<< HEAD
        this.database_id = database_id;
>>>>>>> origin/martijndev
    }


    // TODO move to target database
    public String getCode(){
        return composite.getRuleCode(getName());
=======
>>>>>>> development
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
<<<<<<< HEAD
<<<<<<< HEAD
=======
        object.put("database_id", database_id);
>>>>>>> origin/martijndev
=======
>>>>>>> development
        return object;
    }


    public void validate() {
        composite.validate();
    }
}
