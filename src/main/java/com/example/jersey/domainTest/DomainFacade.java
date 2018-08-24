package com.example.jersey.domainTest;

import com.example.jersey.domainTest.Composit.BusinessRuleComposite;
import com.example.jersey.domainTest.Composit.Elements.Constraint;
import com.example.jersey.domainTest.Composit.Elements.Operator;
import com.example.jersey.domainTest.Composit.attribute.AttributeCompare;
import com.example.jersey.domainTest.Composit.attribute.AttributeList;
import com.example.jersey.domainTest.Composit.attribute.AttributeRange;
import com.example.jersey.domainTest.Composit.Other;
import com.example.jersey.domainTest.Composit.tuple.TupleCompare;
import org.json.JSONObject;

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
                new AttributeCompare(object.getString("table1"), object.getString("column1"), object.getInt("value1"), operator);
            case "alr" :
                new AttributeList(object.getString("table1"), object.getString("column1"), object.getJSONArray("value1"));
            case "aor" :
                Constraint constraint = new Constraint(object.getString("plSQL"));
                new Other(object.getString("table1"), constraint);
            case "tcr" :
                Operator operator1 = new Operator(object.getString("operator"));
                new TupleCompare(object.getString("table1"), object.getString("column1"), object.getString("column2"), operator1);
            case "tor" :
                Constraint constraint1 = new Constraint(object.getString("plSQL"));
                new Other(object.getString("table1"), constraint1);
            default: return null;
        }
    }

}
