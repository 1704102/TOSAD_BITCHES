package com.example.jersey;

import junit.framework.Assert;
import junit.framework.TestCase;
import com.example.jersey.domainTest.Composit.Elements.Operator;

public class OperatorTest extends TestCase {

    public void testOperator() throws Exception {
        boolean expectedTrue = true;
        boolean expectedFalse = false;

        Operator operator = new Operator("");
        Assert.assertEquals(expectedFalse,operator.validate("=?"));
        Assert.assertEquals(expectedTrue,operator.validate("="));
        Assert.assertEquals(expectedTrue,operator.validate("!="));
        Assert.assertEquals(expectedTrue,operator.validate("<"));
        Assert.assertEquals(expectedTrue,operator.validate(">"));
        Assert.assertEquals(expectedTrue,operator.validate("<="));
        Assert.assertEquals(expectedTrue,operator.validate(">="));

    }



}
