package com.example.jersey.domainTest;

import com.example.jersey.Exeptions.AttributeRangeValidateExeption;
import com.example.jersey.Exeptions.OperatorValidateExeption;
import com.example.jersey.domainTest.Composit.Elements.Operator;
import com.example.jersey.domainTest.Composit.attribute.AttributeCompare;
import com.example.jersey.domainTest.Composit.attribute.AttributeList;
import com.example.jersey.domainTest.Composit.attribute.AttributeRange;
import com.example.jersey.domainTest.Composit.tuple.TupleCompare;
import com.example.jersey.domainTest.Composit.tuple.TupleOther;
import org.json.JSONObject;

public class DomainFacade {

    public JSONObject defineAttributeRangeRule(JSONObject object) throws Exception{
        BusinessRule rule = new BusinessRule(object.getInt("database_id"));
        AttributeRange composite = new AttributeRange(object.getString("table1"), object.getString("column1"), object.getInt("value1"), object.getInt("value2"));
        if (!composite.validate()){
            throw new AttributeRangeValidateExeption();
        }
        rule.addComposite(composite);
        return rule.getRule();
    }
    public JSONObject defineAttributeCompareRule(JSONObject object) throws Exception{
        BusinessRule rule = new BusinessRule(object.getInt("database_id"));
        Operator operator = new Operator(object.getString("operator"));
        AttributeCompare composite = new AttributeCompare(object.getString("table1"), object.getString("column1"), object.getInt("value1"), operator);
        if (!operator.validate()){
            throw new OperatorValidateExeption();
        }
        if (!composite.validate()){
            throw new AttributeRangeValidateExeption();
        }

        rule.addComposite(composite);
        return rule.getRule();
    }
    public JSONObject defineAttributeListRule(JSONObject object) throws Exception {
        BusinessRule rule = new BusinessRule(object.getInt("database_id"));
        AttributeList composite = new AttributeList(object.getString("table1"), object.getString("column1"), object.getJSONArray("value1"));
        if (!composite.validate()){
            throw new AttributeRangeValidateExeption();
        }

        rule.addComposite(composite);
        return rule.getRule();
    }
    public JSONObject defineTupleCompareRule(JSONObject object) throws Exception{
        BusinessRule rule = new BusinessRule(object.getInt("database_id"));
        Operator operator = new Operator(object.getString("operator"));
        TupleCompare composite = new TupleCompare(object.getString("table1"), object.getString("column1"), object.getString("column2"), operator);
        if (!operator.validate()){
            throw new OperatorValidateExeption();
        }
        if (!composite.validate()){
            throw new AttributeRangeValidateExeption();
        }
        rule.addComposite(composite);
        return rule.getRule();
    }


    public JSONObject defineTupleOtherRule(JSONObject object) throws Exception{
        BusinessRule rule = new BusinessRule(object.getInt("database_id"));
        TupleOther composite = new TupleOther(object.getString("table1"), object.getString("column1"), object.getString("column2"), object.getString("constraint"));
        if (!composite.validate()){
            throw new AttributeRangeValidateExeption();
        }
        rule.addComposite(composite);
        return rule.getRule();
    }
}
