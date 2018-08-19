package com.example.jersey.domainTest;

import com.example.jersey.Exeptions.AttributeCompareValidateExeption;
import com.example.jersey.Exeptions.AttributeRangeValidateExeption;
import com.example.jersey.Exeptions.OperatorValidateExeption;
import com.example.jersey.database.Target.TargetDatabase;
import com.example.jersey.domainTest.Composit.AttributeCompare;
import com.example.jersey.domainTest.Composit.AttributeRange;
import com.example.jersey.domainTest.Composit.Elements.Operator;
import com.example.jersey.database.TargetDatabaseFacade;
import org.json.JSONObject;
import com.example.jersey.domainTest.Composit.util.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

public class DomainFacade {

    //<editor-fold desc="interEntityRule">
    public void interEntityRulefk(String table1,String table2, String column1, String column2){
        interEntityRulefk(table1, table2);


    }
    public String interEntityRulefk(String table1,String table2){
        TargetDatabaseFacade f = new TargetDatabaseFacade();
        ArrayList<ArrayList<String>> array=f.getForeignkeys();
        Chainforeignkeys fks = new Chainforeignkeys(array,table1,table2);
        String s = fks.getKeyChainSQL();
        return s;

    }
    //</editor-fold>

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

        rule.addComposite(composite);
        return rule.getRule();
    }
    //</editor-fold>





}
