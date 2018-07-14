package com.example.jersey.domainTest;

import com.example.jersey.domainTest.Composit.BusinessRuleComposite;

public class BusinessRule {

    String name;

    String table;
    BusinessRuleComposite composite;

    public BusinessRule(String table){
        this.table = table;
    }

    public String getCode(){
        return composite.getRuleCode(getName(), table);
    }

    public String getName(){
        if (name == null) generateName();
        return name;
    }

    private void generateName(){
        //TODO get number for rule (temporarily 1)
        name = table + composite.getName() + 1;
    }

    public void addComposite(BusinessRuleComposite composite){
        this.composite = composite;
    }


}
