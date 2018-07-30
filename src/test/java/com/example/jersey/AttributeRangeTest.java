package com.example.jersey;

import com.example.jersey.database.repository.DatabaseHelper_Repo;
import com.example.jersey.domainTest.BusinessRule;
import com.example.jersey.domainTest.Composit.AttributeRange;

import com.example.jersey.domainTest.Composit.BusinessRuleComposite;
import junit.framework.Assert;
import junit.framework.TestCase;

import java.sql.PreparedStatement;

public class AttributeRangeTest extends TestCase {

    public void testAttributeRangeName() throws Exception {
        String expected = "CAR_CNS_ARR_1";
        BusinessRule rule = new BusinessRule();
        BusinessRuleComposite composite = new AttributeRange("CAR","type", 5, 10);
        rule.addComposite(composite);
        Assert.assertEquals(expected,rule.getName());
    }

    public void testAttributeRangeCode() throws Exception {
        String expected = "alter table CAR add constraint CAR_CNS_ARR_1 check(type between 5 and 10) ENABLE NOVALIDATE";
        BusinessRule rule = new BusinessRule();
        BusinessRuleComposite composite = new AttributeRange("CAR","type", 5, 10);
        rule.addComposite(composite);
        Assert.assertEquals(expected,rule.getCode());
    }

    public void testAttributeRangeDefine() throws Exception {
        String expected = "alter table CAR add constraint CAR_CNS_ARR_1 check(type between 5 and 10) ENABLE NOVALIDATE";
        BusinessRule rule = new BusinessRule();
        BusinessRuleComposite composite = new AttributeRange("CAR","type", 5, 10);
        rule.addComposite(composite);
        DatabaseHelper_Repo database = new DatabaseHelper_Repo();
        database.connect();
//        rule.DefineRule().forEach(e->{
//            try {
//                System.out.println(e);
//                PreparedStatement statement = database.getPreparedStatement(e);
//                statement.execute();
//            }catch (Exception err){
//                err.printStackTrace();
//            }
//
//        });
        database.disconnect();
    }

    public void testAttributeRangeAlter() throws Exception {
        BusinessRule rule = new BusinessRule(1);
        BusinessRuleComposite composite = new AttributeRange(1,"BUS","PETROL", 5, 10);
        rule.addComposite(composite);
        DatabaseHelper_Repo database = new DatabaseHelper_Repo();
        database.connect();
//        rule.alterRule().forEach(e->{
//            try {
//                System.out.println(e);
//                PreparedStatement statement = database.getPreparedStatement(e);
//                statement.execute();
//            }catch (Exception err){
//                err.printStackTrace();
//            }
//
//        });
        database.disconnect();
    }
}
