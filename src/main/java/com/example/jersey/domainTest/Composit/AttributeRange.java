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
    public String getRuleCode() {
        return "check(" + column + " between " + valueLow + " and " + valueHigh + ")";
    }

    @Override
    public String getName() {
        return "_CNS_ARR_";
    }
}
