package com.example.jersey;

import com.example.jersey.domainTest.BusinessRule;
import com.example.jersey.domainTest.Composit.AttributeRange;

import com.example.jersey.domainTest.Composit.BusinessRuleComposite;
import junit.framework.Assert;
import junit.framework.TestCase;

public class AttributeRangeTest extends TestCase {

    public void testAttributeRangeName() throws Exception {
        String expected = "CAR_CNS_ARR_1";
        BusinessRule rule = new BusinessRule("CAR");
        BusinessRuleComposite composite = new AttributeRange("type", 5, 10);
        rule.addComposite(composite);
        Assert.assertEquals(expected,rule.getName());
    }

    public void testAttributeRangeCode() throws Exception {
        String expected = "alter table CAR add constraint CAR_CNS_ARR_1 check(type between 5 and 10) ENABLE NOVALIDATE";
        BusinessRule rule = new BusinessRule("CAR");
        BusinessRuleComposite composite = new AttributeRange("type", 5, 10);
        rule.addComposite(composite);
        Assert.assertEquals(expected,rule.getCode());
    }
}
