package com.example.jersey.domainTest.Composit.Elements;

public class foreignkeyObject {
    private String table1;
    private String table2;
    private String column1;

    @Override
    public String toString() {
        return "foreignkeyObject{" +
                "table1='" + table1 + '\'' +
                ", table2='" + table2 + '\'' +
                ", column1='" + column1 + '\'' +
                ", column2='" + column2 + '\'' +
                '}';
    }

    private String column2;

    public foreignkeyObject(String table1,  String column1,String table2, String column2) {
        this.table1 = table1.toUpperCase();
        this.table2 = table2.toUpperCase();
        this.column1 = column1.toUpperCase();
        this.column2 = column2.toUpperCase();
    }

    public boolean Alligned(String s){
        if(s.equals(table1) || s.equals(table2)){
            return true;
        }
        return false;
    }

    public String getTable1() {
        return table1;
    }

    public void setTable1(String table1) {
        this.table1 = table1;
    }

    public String getTable2() {
        return table2;
    }

    public void setTable2(String table2) {
        this.table2 = table2;
    }

    public String getColumn1() {
        return column1;
    }

    public void setColumn1(String column1) {
        this.column1 = column1;
    }

    public String getColumn2() {
        return column2;
    }

    public void setColumn2(String column2) {
        this.column2 = column2;
    }
}