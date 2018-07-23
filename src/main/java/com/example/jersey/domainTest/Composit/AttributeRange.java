package com.example.jersey.domainTest.Composit;

import java.util.ArrayList;
import java.util.Arrays;

public class AttributeRange implements BusinessRuleComposite {

    private int id;
    private String table;
    private String column;

    private int valueLow;
    private int valueHigh;

    public AttributeRange(int id, String table, String column, int valueLow, int valueHigh) {
        this.id = id;
        this.table = table;
        this.column = column;
        this.valueLow = valueLow;
        this.valueHigh = valueHigh;
    }

    public AttributeRange(String table, String column, int valueLow, int valueHigh) {
        this.table = table;
        this.column = column;
        this.valueLow = valueLow;
        this.valueHigh = valueHigh;
    }

    @Override
    public String getRuleCode(String name) {
        return "alter table " + table + " add constraint " + name + " check(" + column + " between " + valueLow + " and " + valueHigh + ") ENABLE NOVALIDATE";
    }

    @Override
    public ArrayList<String> getRuleDefine() {
        return new ArrayList<String>(Arrays.asList(
                String.format("insert into ATTRIBUTERANGE (ID, TABLE1, COLUMN1, VALUE1, VALUE2) values (%d, '%s', '%s', %d, %d)", 1, table, column, valueLow, valueHigh),
                String.format("insert into BUSINESSRULE_COMPONENT (BUSINESSRULE_ID, ATTRIBUTERANGE_ID) values (%d, %d)", 1, 1)));

    }

    @Override
    public ArrayList<String> getRuleAlter() {
        return new ArrayList<String>(Arrays.asList(
                String.format("update ATTRIBUTERANGE set TABLE1 = '%s', COLUMN1 = '%s', VALUE1 = %d, VALUE2 = %d where ID = %d", table, column, valueLow, valueHigh ,id)));
    }

    @Override
    public String getName() {
        return table + "_CNS_ARR_";
    }

    @Override
    public boolean validate() {
        if (valueLow > valueHigh) return false;
        if (valueHigh < valueLow) return false;
        if (valueLow == valueHigh) return false;
        return true;
    }
}
