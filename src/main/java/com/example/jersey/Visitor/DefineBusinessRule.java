package com.example.jersey.Visitor;

import com.example.jersey.domain.AttributeRule;
import com.example.jersey.domain.BusinessRuleComposite;
import com.example.jersey.domain.CompareRule;
import com.example.jersey.domain.Key;
import com.example.jersey.domain.Operator;

// This could also be stored in a database where it will be managed. Although the types are very loosely coupled
public class DefineBusinessRule {

	public BusinessRuleComposite defineAttributeCompareRule(String attribute, String operator, String compare) {
		BusinessRuleComposite acmp = new BusinessRuleComposite("ACMP");
		
		AttributeRule attributecomponent = new AttributeRule(attribute);
		Operator operatorcomponent = new Operator(operator);
		CompareRule comparecomponent = new CompareRule(compare);
		
		Key<AttributeRule> key1 = new Key<>("attribute",AttributeRule.class);
		Key<CompareRule> key2 = new Key<>("operator",CompareRule.class);
		Key<Operator> key3 = new Key<>("compare",Operator.class);
		
		acmp.put(key1, attributecomponent);
		acmp.put(key2, operatorcomponent);
		acmp.put(key3, comparecomponent);
		return acmp;
	}
	
	// TODO: dynamisch het type controleren (is possible now with type)
	/*
	 * 3 validate rule
	public boolean validateRule( ) {
		// TODO hard coded check 
		// NOTE: how about defining all the rules from a centralized controller?
		List<Key<?>> acmp = new ArrayList<Key<?>>();
		Key<AttributeRule> key1 = new Key<>("attribute",AttributeRule.class);
		Key<AttributeRule> key2 = new Key<>("operator",AttributeRule.class);
		Key<Operator> key3 = new Key<>("compare",Operator.class);
		acmp.add(key1);
		acmp.add(key2);
		acmp.add(key3);
	
	
		// 3.1 check the components first
		Iterator<BusinessRuleComponent> compositecomps = composite.getChildren().iterator();
		// 3.2
		// - requirements
		// - number of classes need to match

		boolean match = false;
		int requirednumOfMatches = composite.getChildren().size();
		int measuredNumOfMatches = 0;
		while(compositecomps.hasNext()) {
			BusinessRuleComponent componentA = compositecomps.next();
			Class<?> classA = componentA.getClass();
			
			for(BusinessRuleComponent component : acmp) {
				// according to source you can 
				// get the type of Bluecar (subtype) from Car (supertype)
				  
				BusinessRuleComponent classB = composite.getSubtype(); // attribute? operator? comparison?
				
				if(classA instanceof classB) {
					measuredNumOfMatches += 1;
					break;
				}
			}
		}
		// composite doesn't match.
	return false;
	}*/// TODO: "with a strategy" in java
}
