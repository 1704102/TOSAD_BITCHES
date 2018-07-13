package com.example.jersey.Generator;

import com.example.jersey.database.TargetDatabase;
import com.example.jersey.domain.BusinessRuleComponent;

public class BusinessRuleGenerator {

    public void generateBusinessRule(BusinessRuleComponent rule){
       // System.out.println(rule.getComponentName());
        generateAttributeRangeRule();
    }
	// businessruleName_database_table-column_operator_comparisontype
	// 4				4		 3	   3	  2		   4			 = 24 digits
	// ACMP_prod_modepks_<#_str
	// ACMP_deal_vehisea_<#_num (24 digits)
	// 123456789012345678901234

    //TODO add parameters
    public void generateAttributeRangeRule(){
        String name = "haha";
        String table = "CAR";
        String column = "AMOUNT";
        int valueLow = 5 ;
        int valueHigh = 10;

        String sql = "alter table " + table + " add constraint " + name + " check(" + column + " between " + valueLow + " and " + valueHigh + " )ENABLE NOVALIDATE";

        TargetDatabase database = new TargetDatabase();
        database.saveRule(sql);
    }
    /*
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
    */
}
