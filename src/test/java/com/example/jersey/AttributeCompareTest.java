package com.example.jersey;

import com.example.jersey.domainTest.BusinessRule;
import com.example.jersey.domainTest.Composit.AttributeCompare;
import com.example.jersey.domainTest.Composit.AttributeRange;
import com.example.jersey.domainTest.Composit.BusinessRuleComposite;
import com.example.jersey.domainTest.Composit.Elements.Operator;
import junit.framework.Assert;
import junit.framework.TestCase;

public class AttributeCompareTest extends TestCase {

    public void testAttributeRangeName() throws Exception {
        String expected = "CAR_CNS_ACR_1";
        BusinessRule rule = new BusinessRule("CAR");
        Operator operator = new Operator("<");
        BusinessRuleComposite composite = new AttributeCompare("type", 10, operator);
        rule.addComposite(composite);
        Assert.assertEquals(expected,rule.getName());
    }

    public void testAttributeRangeCode() throws Exception {
        String expected = "alter table CAR add constraint CAR_CNS_ACR_1 check(type > 10) ENABLE NOVALIDATE";
        BusinessRule rule = new BusinessRule("CAR");
        Operator operator = new Operator(">");
        BusinessRuleComposite composite = new AttributeCompare("type", 10, operator);
        rule.addComposite(composite);
        Assert.assertEquals(expected,rule.getCode());
    }
}
