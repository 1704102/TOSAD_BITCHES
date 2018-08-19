package com.example.jersey.domainTest.Composit.Elements;

public class InterentityRule {
    String table1;
    String table2;
    String column1;
    String column2;
    public InterentityRule(String table1, String table2,String column1, String column2, String foreignkeyChain ){
        this.table1= table1;
        this.table2= table2;
        this.column1= column1;
        this.column2 = column2;
    }
    public String getSQL(){
        String sql =null;

        return sql;
    }
}
