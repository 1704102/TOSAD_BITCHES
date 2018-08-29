package com.example.jersey.domainTest;

import com.example.jersey.database.Target.TargetDatabaseFacade;
import com.example.jersey.domainTest.Composit.BusinessRuleComposite;
import com.example.jersey.domainTest.Composit.Elements.Chainforeignkeys;
import com.example.jersey.domainTest.Composit.Elements.Constraint;
import com.example.jersey.domainTest.Composit.Elements.Operator;
import com.example.jersey.domainTest.Composit.attribute.AttributeCompare;
import com.example.jersey.domainTest.Composit.attribute.AttributeList;
import com.example.jersey.domainTest.Composit.attribute.AttributeRange;
import com.example.jersey.domainTest.Composit.entity.EntityCompare;
import com.example.jersey.domainTest.Composit.other.Other;
import com.example.jersey.domainTest.Composit.tuple.TupleCompare;
import org.json.JSONObject;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;

public class DomainFacade {

    public JSONObject defineRule(JSONObject object, String type) throws Exception{
        BusinessRule rule = new BusinessRule(object.getInt("database_id"));
        rule.addComposite(getComposite(object, type));
        rule.validate();
        return rule.getRule();
    }


    private BusinessRuleComposite getComposite(JSONObject object, String type) throws Exception{
        switch (type){
            case "arr" :
                return new AttributeRange(object.getString("table1"), object.getString("column1"), object.getInt("value1"), object.getInt("value2"));
            case "acr" :
                Operator operator = new Operator(object.getString("operator"));
                 return new AttributeCompare(object.getString("table1"), object.getString("column1"), object.getInt("value1"), operator);
            case "alr" :
                return new AttributeList(object.getString("table1"), object.getString("column1"), object.getJSONArray("value1"));
            case "or" :
                Constraint constraint = new Constraint(object.getString("plSQL"));
                return new Other(object.getString("table1"), constraint);
            case "tcr" :
                Operator operator1 = new Operator(object.getString("operator"));
                return new TupleCompare(object.getString("table1"), object.getString("column1"), object.getString("column2"), operator1);
            case "iecr" :
//                EntityCompare compare = new EntityCompare();
                return null;
            default: return null;
        }
    }

    public void interEntityRule(String table1,String table2, String column1, String column2,String operator) throws Exception{
        //makebuisinessrule
        System.out.println(table1+table2+column1+column2);
        table1= table1.toUpperCase();
        table2= table2.toUpperCase();
        column1=column1.toUpperCase();
        column2=column2.toUpperCase();
        String s=interEntityRuleFk(table1, table2);
        TargetDatabaseFacade d1 = new TargetDatabaseFacade();
        d1.createInterEntityRule(s, table1,table2,column1,column2,operator,name);

    }

    public String interEntityRuleFk(String table1,String table2) throws Exception{
        table1=table1.toUpperCase();
        table2=table2.toUpperCase();
        TargetDatabaseFacade f = new TargetDatabaseFacade();
        ArrayList<ArrayList<String>> array=f.getForeignkeys();
        Chainforeignkeys fks = new Chainforeignkeys(array,table1,table2);
        String s = fks.getKeyChainSQL();
        String s1= fks.getFrom();
        System.out.println(s1+"greetings from from function");
        System.out.println(s);
        return s;

    }


}
