package com.example.jersey.Generator;

public class BusinessRuleGenearator {

    public void generateBusinessRule(){

    }

    public void generateAttributeRangeRule(){
        String table;
        String column;
        int valueLow;
        int valueHigh;
    }
    public void generateAttributeCompareRule(){
        String table;
        String column;
        int value;
        char compare;
    }
    public void generateAttributeListRule(){
        String table;
        String column;
        String[] list;
    }
    public void generateAttributeOtherRule(){
        String table;
        String column;
        String constraint;
    }
    public void generateTupleCompareRule(){
        String table;
        String column1;
        String column2;
        char compare;
    }
    public void generateTupleOtherRule(){
        String table;
        String column1;
        String column2;
        String constraint;
    }
    public void generateInter1EntityCompareRule(){
        String table1;
        String table2;
        String primaryKey;
        String foreignKey;
        String column1;
        String column2;
        char compare;
    }
    public void generateEntityOtherRule(){
        String table1;
        String constraint;
        String column1;
        String column2;
    }
    public void generateModifyRule(){
        String table1;
        String table2;
        String constraint;
    }
}
