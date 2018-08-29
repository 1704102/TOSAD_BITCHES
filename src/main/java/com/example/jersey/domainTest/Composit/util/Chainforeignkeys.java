package com.example.jersey.domainTest.Composit.util;

import java.util.ArrayList;

public class Chainforeignkeys {
    ArrayList<foreignkeyObject> fko = new ArrayList<>();
    private String startTable;
    private String endTable;
    public Chainforeignkeys(ArrayList<ArrayList<String>> array, String StartTable,String EndTable){
        for(ArrayList<String> s : array){

           String table1= s.get(0);
           String column1= s.get(1);
           String table2= s.get(2);
           String column2= s.get(3);

            foreignkeyObject f = new foreignkeyObject(table1,column1,table2,column2);

            fko.add(f);

        }
        startTable=StartTable;
        endTable=EndTable;
    }
    public String getFrom(){
        String s= "";


        return s;
    }

    public String froms() {
        String s = null;
        ArrayList<String> fromstring= new ArrayList<>();
        for(foreignkeyObject f:fko){
            //herro
        }
        return s;
    }

    public String getKeyChainSQL(){
        String s = "";
        ArrayList<foreignkeyObject> array = fko;
        ArrayList<foreignkeyObject> array3=new ArrayList<foreignkeyObject>();
        ArrayList<foreignkeyObject> array2 = new ArrayList<>();
        for(foreignkeyObject f: array){
            if(startTable.equals(f.getTable1()) || startTable.equals(f.getTable2())){
               if(endTable.equals(f.getTable1()) || endTable.equals(f.getTable2())){
                   s = f.getTable1()+"."+f.getColumn1()+"="+f.getTable2()+"."+f.getColumn2();
                   System.out.println(s);
                   System.out.println("howa");
                   return s;
               }
               array2.add(f);

            }
            else{
                array3.add(f);
            }

        }

        for(foreignkeyObject f : array2){
            s = f.getTable1()+"."+f.getColumn1()+"="+f.getTable2()+"."+f.getColumn2();
            String table1=f.getTable1();
            String table2=f.getTable2();
            String b =getKeyChainSQL2ndlayer(array3, s, table1);
            String b2 =getKeyChainSQL2ndlayer(array3, s, table2);
            if(!b.equals("false")){
                return b;
            }
            if(!b2.equals("false")){
                return b;
            }

        }
        s="false";
        System.out.println(s);

        return s;

    }


    public String getKeyChainSQL2ndlayer(ArrayList<foreignkeyObject> fo, String sql, String tablename){
        String s = sql;
        ArrayList<foreignkeyObject> array = fo;
        ArrayList<String> strings= new ArrayList<String>();
        ArrayList<foreignkeyObject> array3=new ArrayList<foreignkeyObject>();

        ArrayList<foreignkeyObject> array2 = new ArrayList<>();
        for(foreignkeyObject f: array){
            boolean existing=true;
            for(String s1: strings){

                if(s1.equals(f.getTable1()) || s1.equals(f.getTable2())){
                    existing=true;
                }

            }
            if(existing==true){

            }
            if(startTable.equals(tablename) || startTable.equals(tablename)){

                if(endTable.equals(f.getTable1()) || endTable.equals(f.getTable2())){
                    s = s + " and " +f.getTable1()+"."+f.getColumn1()+"="+f.getTable2()+"."+f.getColumn2();
                    System.out.println(s+ "hellofinal");
                    return s;
                }
                array2.add(f);

            }
            else{
                array3.add(f);
            }

        }


        for(foreignkeyObject f : array2){

        }
        s="false";
        System.out.println(s);

        return s;

    }

}
