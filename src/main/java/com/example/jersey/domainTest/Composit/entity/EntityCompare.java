package com.example.jersey.domainTest.Composit.entity;

import com.example.jersey.domainTest.Composit.BusinessRuleComposite;
import com.example.jersey.domainTest.Composit.Elements.Chainforeignkeys;
import com.example.jersey.domainTest.Composit.Elements.Operator;
import org.json.JSONObject;

public class EntityCompare implements BusinessRuleComposite {
    private int id;

    private String table1;
    private String table2;
    private String column1;
    private String column2;
    private Operator operator;
    private Chainforeignkeys foreignKey;

    public EntityCompare(int id, String table1, String table2, String column1, String column2, Operator operator, Chainforeignkeys foreignKey) {
        this.id = id;
        this.table1 = table1;
        this.table2 = table2;
        this.column1 = column1;
        this.column2 = column2;
        this.operator = operator;
        this.foreignKey = foreignKey;
    }

    public EntityCompare(String table1, String table2, String column1, String column2, Operator operator, Chainforeignkeys foreignKey) {
        this.table1 = table1;
        this.table2 = table2;
        this.column1 = column1;
        this.column2 = column2;
        this.operator = operator;
        this.foreignKey = foreignKey;
    }

    @Override
    public String getName() {
        return table1 + "_CNS_IECR_";
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
        object.put("table1", table1);
        object.put("table2", table2);
        object.put("column1", column1);
        object.put("column2", column2);
        object.put("operator", operator.getValue());
        object.put("foreignKey", foreignKey.froms() + " where " + foreignKey.getKeyChainSQL());
        return object;
    }
}
