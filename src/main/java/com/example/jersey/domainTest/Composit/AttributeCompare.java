package com.example.jersey.domainTest.Composit;

import com.example.jersey.domainTest.Composit.Elements.Operator;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;

public class AttributeCompare implements BusinessRuleComposite{

    String table;
    private String column;
    private int value;
    private Operator operator;

    public AttributeCompare(String table, String column, int value, Operator operator) {
        this.table = table;
        this.column = column;
        this.value = value;
        this.operator = operator;
    }

    @Override
    public String getRuleCode(String name) {
        return "alter table " + table +  " add constraint " + name + " check(" + column + " " + operator.getValue() + " " + value + ") ENABLE NOVALIDATE";
    }

//    //TODO define rule code update
//    @Override
//    public ArrayList<String> getRuleDefine() {
//        return new ArrayList<String>(Arrays.asList(
//                String.format("insert into ATTRIBUTERANGE (ID, TABLE1, COLUMN1, VALUE1, VALUE2) values (%d, \"%s\", \"%s\", %d, %d)", 1, table, column, 1, 1)));
//    }


    @Override
    public String getName() {
        return table + "_CNS_ACR_";
    }

    @Override
    public boolean validate() {
        return true;
    }

    @Override
    public JSONObject getComposite() {
        return null;
    }

}
