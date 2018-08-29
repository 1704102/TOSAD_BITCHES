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
    public void interEntityRule(String table1,String table2, String column1, String column2,String operator){
        //makebuisinessrule
        System.out.println(table1+table2+column1+column2);
        table1= table1.toUpperCase();
        table2= table2.toUpperCase();
        column1=column1.toUpperCase();
        column2=column2.toUpperCase();
        System.out.println("gogo");
        String s=interEntityRulefk(table1, table2);
        TargetDatabaseFacade d1 = new TargetDatabaseFacade();
        d1.createInterEntityRule(s, table1,table2,column1,column2,operator,"test");

    }
    public String interEntityRulefk(String table1,String table2){
        table1=table1.toUpperCase();
        table2=table2.toUpperCase();
        TargetDatabaseFacade f = new TargetDatabaseFacade();
        ArrayList<ArrayList<String>> array=f.getForeignkeys();
        Chainforeignkeys fks = new Chainforeignkeys(array,table1,table2);
        String s = fks.getKeyChainSQL();
        String s1= fks.froms();
        String s2 = s1+" where "+s;
        System.out.println(s1);
        System.out.println(s);
        System.out.println(s1+" where "+s);
        return s2;

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
