package com.example.jersey.domainTest;

import com.example.jersey.domainTest.Composit.BusinessRuleComposite;

import java.util.ArrayList;
import java.util.zip.ZipEntry;

public class BusinessRule {

    int id;
    String name;
    String status;

    BusinessRuleComposite composite;

    public BusinessRule(){

    }

    public BusinessRule(int id){
        this.id = id;
    }

    public String getCode(){
        return composite.getRuleCode(getName());
    }

    public ArrayList<String> DefineRule(){
        status = "new";
        ArrayList<String> queries = composite.getRuleDefine();
        queries.add(0, String.format("insert into BUSINESSRULE (ID, NAME, STATUS) values (%d, '%s', '%s')", 1, getName(), status));
        return queries;
    }

    public ArrayList<String> alterRule(){
        ArrayList<String> queries = composite.getRuleAlter();
        generateName();
        queries.add(0, String.format("update BUSINESSRULE set NAME = '%s', STATUS = '%s' where id = %d", getName(), status, id));
        return queries;
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


}
