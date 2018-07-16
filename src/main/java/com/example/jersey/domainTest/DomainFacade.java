package com.example.jersey.domainTest;

import com.example.jersey.Exeptions.AttributeRangeValidateExeption;
import com.example.jersey.domainTest.Composit.AttributeRange;
import com.example.jersey.domainTest.Composit.Elements.Operator;
import org.json.JSONObject;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

public class DomainFacade {

    public ArrayList<String> defineAttributeRangeRule(JSONObject object) throws Exception{
        BusinessRule rule = new BusinessRule();
        AttributeRange composite = new AttributeRange(object.getString("table"), object.getString("column"), object.getInt("value1"), object.getInt("value2"));
        if (!composite.validate()){
            throw new AttributeRangeValidateExeption();
        }
        rule.addComposite(composite);
        return rule.DefineRule();
    }
//
//    public Response defineAttributeCompareRule(JSONObject object){
//        Operator operator = new Operator(object.getString("operator"));
//        if (!operator.validate()){
//            return Response.status(Response.Status.CONFLICT).entity( object.getString("operator") + " is not a valid operator").build();
//        }
//    }



}
