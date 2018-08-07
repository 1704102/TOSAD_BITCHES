package com.example.jersey;

import com.example.jersey.domainTest.BusinessRule;
import com.example.jersey.domainTest.Composit.TupleCompare;
import com.example.jersey.domainTest.Composit.Elements.Operator;
import com.example.jersey.domainTest.Composit.BusinessRuleComposite;

import junit.framework.TestCase;
import junit.framework.Assert;

public class TupleCompareTest extends TestCase{
	public void testTupleCompareName() {
		String expected = "CAR_CNS_TCR";
		BusinessRule rule = new BusinessRule();
		//
		// The intended equasion determines if the components of the engine block have
		// are suitable in diameter size.
		// https://maken.wikiwijs.nl/bestanden/252620/Opbouw%20van%20de%20motor.pdf
		// 
		Operator operator = new Operator("==");
		BusinessRuleComposite composite = new TupleCompare("CAR", "cylinderhead", "headgasket", operator);
		rule.addComposite(composite);
		Assert.assertEquals(expected,rule.getName());
	}
	
	public void testTupleCompareCode() {
		String expected = "CAR_CNS_TCR";
		BusinessRule rule = new BusinessRule();
		//
		// The intended equasion determines if the components of the engine block have
		// are suitable in diameter size.
		// https://maken.wikiwijs.nl/bestanden/252620/Opbouw%20van%20de%20motor.pdf
		// 
		Operator operator = new Operator("==");
		BusinessRuleComposite composite = new TupleCompare("CAR", "cylinderhead", "headgasket", operator);
		rule.addComposite(composite);
		Assert.assertEquals(expected,rule.getCode());
	}
}
