package com.example.jersey.domainTest.Composit;

import com.example.jersey.domainTest.Composit.Elements.Operator;

public class AttributeCompare implements BusinessRuleComposite{

    private String column;
    private int value;
    private Operator operator;

    public AttributeCompare(String column, int value, Operator operator) {
        this.column = column;
        this.value = value;
        this.operator = operator;
    }

    @Override
    public String getRuleCode(String name, String table) {
        return "alter table " + table +  " add constraint " + name + " check(" + column + " " + operator.getValue() + " " + value + ") ENABLE NOVALIDATE";
    }

    @Override
    public String getName() {
        return "_CNS_ACR_";
    }
}
