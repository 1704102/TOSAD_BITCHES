package com.example.jersey.domainTest.Composit;

public class AttributeRange implements BusinessRuleComposite {

    private String column;

    private int valueLow;
    private int valueHigh;

    public AttributeRange(String column, int valueLow, int valueHigh) {
        this.column = column;
        this.valueLow = valueLow;
        this.valueHigh = valueHigh;
    }

    @Override
    public String getRuleCode(String name, String table) {
        return "alter table " + table + " add constraint " + name + " check(" + column + " between " + valueLow + " and " + valueHigh + ") ENABLE NOVALIDATE";
    }

    @Override
    public String getName() {
        return "_CNS_ARR_";
    }
}
