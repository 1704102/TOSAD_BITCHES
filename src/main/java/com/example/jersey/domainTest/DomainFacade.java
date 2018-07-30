package com.example.jersey.domainTest;

import com.example.jersey.Exeptions.AttributeCompareValidateExeption;
import com.example.jersey.Exeptions.AttributeRangeValidateExeption;
import com.example.jersey.Exeptions.OperatorValidateExeption;
import com.example.jersey.domainTest.Composit.AttributeCompare;
import com.example.jersey.domainTest.Composit.AttributeRange;
import com.example.jersey.domainTest.Composit.Elements.Operator;
import org.json.JSONObject;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

public class DomainFacade {

    public JSONObject defineAttributeRangeRule(JSONObject object) throws Exception{
        BusinessRule rule = new BusinessRule();
        AttributeRange composite = new AttributeRange(object.getString("table"), object.getString("column"), object.getInt("value1"), object.getInt("value2"));
        if (!composite.validate()){
            throw new AttributeRangeValidateExeption();
        }
        rule.addComposite(composite);
        return rule.getRule();
    }

    public JSONObject defineAttributeCompareRule(JSONObject object) throws Exception{
        BusinessRule rule = new BusinessRule();
        Operator operator = new Operator(object.getString("operator"));
        AttributeCompare composite = new AttributeCompare(object.getString("table"), object.getString("column"), object.getInt("value1"), operator);
        if (!operator.validate()){
            throw new OperatorValidateExeption();
        }
        if (!composite.validate()){
            throw new AttributeRangeValidateExeption();
        }

        rule.addComposite(composite);
        return rule.getRule();
    }






}
