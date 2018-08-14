package com.example.jersey.domainTest;

import com.example.jersey.Exeptions.AttributeCompareValidateExeption;
import com.example.jersey.Exeptions.AttributeRangeValidateExeption;
import com.example.jersey.Exeptions.OperatorValidateExeption;
import com.example.jersey.domainTest.Composit.AttributeCompare;
<<<<<<< HEAD
import com.example.jersey.domainTest.Composit.AttributeRange;
import com.example.jersey.domainTest.Composit.Elements.Operator;
=======
import com.example.jersey.domainTest.Composit.AttributeList;
import com.example.jersey.domainTest.Composit.AttributeRange;
import com.example.jersey.domainTest.Composit.Elements.Operator;
import com.example.jersey.domainTest.Composit.TupleCompare;
>>>>>>> origin/martijndev
import org.json.JSONObject;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

public class DomainFacade {

<<<<<<< HEAD
    //<editor-fold desc="AttributeRangeRule">
    public JSONObject defineAttributeRangeRule(JSONObject object) throws Exception{
        BusinessRule rule = new BusinessRule();
        AttributeRange composite = new AttributeRange(object.getString("table"), object.getString("column"), object.getInt("value1"), object.getInt("value2"));
=======
    public JSONObject defineAttributeRangeRule(JSONObject object) throws Exception{
        BusinessRule rule = new BusinessRule(object.getInt("database_id"));
        AttributeRange composite = new AttributeRange(object.getString("table1"), object.getString("column1"), object.getInt("value1"), object.getInt("value2"));
>>>>>>> origin/martijndev
        if (!composite.validate()){
            throw new AttributeRangeValidateExeption();
        }
        rule.addComposite(composite);
        return rule.getRule();
    }
<<<<<<< HEAD
    //</editor-fold>
    //<editor-fold desc="AttributeCompareRule">
    public JSONObject defineAttributeCompareRule(JSONObject object) throws Exception{
        BusinessRule rule = new BusinessRule();
        Operator operator = new Operator(object.getString("operator"));
        AttributeCompare composite = new AttributeCompare(object.getString("table"), object.getString("column"), object.getInt("value1"), operator);
=======
    public JSONObject defineAttributeCompareRule(JSONObject object) throws Exception{
        BusinessRule rule = new BusinessRule(object.getInt("database_id"));
        Operator operator = new Operator(object.getString("operator"));
        AttributeCompare composite = new AttributeCompare(object.getString("table1"), object.getString("column1"), object.getInt("value1"), operator);
>>>>>>> origin/martijndev
        if (!operator.validate()){
            throw new OperatorValidateExeption();
        }
        if (!composite.validate()){
            throw new AttributeRangeValidateExeption();
        }

        rule.addComposite(composite);
        return rule.getRule();
    }
<<<<<<< HEAD
    //</editor-fold>

=======
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
>>>>>>> origin/martijndev




}
