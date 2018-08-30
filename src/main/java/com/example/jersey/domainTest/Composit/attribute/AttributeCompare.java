package com.example.jersey.domainTest.Composit.attribute;

import com.example.jersey.domainTest.Composit.BusinessRuleComposite;
import com.example.jersey.domainTest.Composit.Elements.Operator;
import org.json.JSONObject;

public class AttributeCompare implements BusinessRuleComposite {

    private int id;

    String table;
    private String column;
    private int value;
    private Operator operator;

    public AttributeCompare(int id, String table, String column, int value, Operator operator) {
        this.id = id;
        this.table = table;
        this.column = column;
        this.value = value;
        this.operator = operator;
    }

    public AttributeCompare(String table, String column, int value, Operator operator) {
        this.table = table;
        this.column = column;
        this.value = value;
        this.operator = operator;
    }

    @Override
    public String getName() {
        return table + "_CNS_ACR_";
    }

    @Override
    public boolean validate(){
        if (!operator.validate()) return false;
        return true;
    }

    @Override
    public JSONObject getComposite() {
        JSONObject object = new JSONObject();
        object.put("id", id);
<<<<<<< HEAD:src/main/java/com/example/jersey/domainTest/Composit/AttributeCompare.java
<<<<<<< HEAD
        object.put("table", table);
        object.put("column", column);
        object.put("value", value);
=======
        object.put("table1", table);
        object.put("column1", column);
        object.put("value1", value);
>>>>>>> origin/martijndev
=======
        object.put("table", table);
        object.put("column", column);
        object.put("value", value);
>>>>>>> development:src/main/java/com/example/jersey/domainTest/Composit/attribute/AttributeCompare.java
        object.put("operator", operator.getValue());
        return object;
    }

}
