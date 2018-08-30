package com.example.jersey.domainTest;

<<<<<<< HEAD
import com.example.jersey.Exeptions.AttributeCompareValidateExeption;
import com.example.jersey.Exeptions.AttributeRangeValidateExeption;
import com.example.jersey.Exeptions.OperatorValidateExeption;
import com.example.jersey.domainTest.Composit.AttributeCompare;
import com.example.jersey.domainTest.Composit.AttributeRange;
import com.example.jersey.domainTest.Composit.Elements.Operator;
=======
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
>>>>>>> origin/martijndev
import org.json.JSONObject;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;

public class DomainFacade {

<<<<<<< HEAD
    //<editor-fold desc="AttributeRangeRule">
    public JSONObject defineAttributeRangeRule(JSONObject object) throws Exception{
        BusinessRule rule = new BusinessRule();
        AttributeRange composite = new AttributeRange(object.getString("table"), object.getString("column"), object.getInt("value1"), object.getInt("value2"));
        if (!composite.validate()){
            throw new AttributeRangeValidateExeption();
        }
        rule.addComposite(composite);
        return rule.getRule();
    }
    //</editor-fold>
    //<editor-fold desc="AttributeCompareRule">
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
=======
    public JSONObject defineRule(JSONObject object, String type) throws Exception{
        BusinessRule rule = new BusinessRule(object.getInt("database_id"));
        rule.addComposite(getComposite(object, type));
        rule.validate();
        return rule.getRule();
    }
>>>>>>> origin/martijndev

    public String getForeignKey(JSONObject object) throws Exception{
        Chainforeignkeys foreignkey = new Chainforeignkeys(new TargetDatabaseFacade().getForeignkeys(), object.getString("table1"), object.getString("table2"));
        return foreignkey.froms() + " where " + foreignkey.getKeyChainSQL();
    }
<<<<<<< HEAD
    //</editor-fold>

=======

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
                Operator operator2 = new Operator(object.getString("operator"));
                Chainforeignkeys foreignkey = new Chainforeignkeys(new TargetDatabaseFacade().getForeignkeys(), object.getString("table1"), object.getString("table2"));
                return new EntityCompare(object.getString("table1"), object.getString("table2"), object.getString("column1"), object.getString("column2"), operator2, foreignkey);
            default: return null;
        }
    }
>>>>>>> origin/martijndev



}
