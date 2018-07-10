package com.example.jersey.Visitor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.example.jersey.domain.AttributeRule;
import com.example.jersey.domain.BusinessRuleComponent;
import com.example.jersey.domain.BusinessRuleComposite;
import com.example.jersey.domain.CompareRule;
import com.example.jersey.domain.Operator;

public class DefineBusinessRuleService {
	// Matcher;
	
	private List<BusinessRuleComposite> allComposites = new ArrayList<BusinessRuleComposite>();
	// NOTE: how about an observable for the next Demo?
	private Map<Integer,BusinessRuleComposite> filledComposites = new HashMap<Integer,BusinessRuleComposite>();

	public DefineBusinessRuleService() {
		BusinessRuleComposite acmp = new BusinessRuleComposite("ACMP");
		acmp.add(new AttributeRule(new String()));
		acmp.add(new CompareRule(new String()));
		acmp.add(new Operator(new String()));
		allComposites.add(acmp);
		
		// ACMP_apple_<_5_prod
		
		
	}
	
	// TODO: missing functionality: generate businessRule
	private String getCode() {
		Iterator<BusinessRuleComposite> compositeIter = allComposites.iterator();
		return compositeIter.next().getTerminalExpression();
	}
	
	public BusinessRuleComposite getCompositeByComponents(List<BusinessRuleComponent> components) {
		Iterator<BusinessRuleComposite> compositeIter = allComposites.iterator();
		while(compositeIter.hasNext()) {
		BusinessRuleComposite wildcard = compositeIter.next();
			if( wildcard.getChildren().containsAll(components) ) {
				return wildcard;
			}
		}
		return null; // NOTE: In case some nonsensical comparison is executed
	}
	
	public boolean newBusinessRule(BusinessRuleComposite composite) {
		int index = filledComposites.size();
		int oldSize = filledComposites.size();
		System.out.println("serviceprovider newcomposite: " + index);
		filledComposites.put(index, composite);
		if(filledComposites.size() +1 != oldSize) { 
			return true;
			}
		return false;
	}
	
	public BusinessRuleComposite getCompositeByKey(int key) {
		return filledComposites.get(key);
	}
	
	public List<BusinessRuleComposite> getAllComposites() {
		System.out.println(filledComposites.values());
		List<BusinessRuleComposite> converted = new ArrayList<BusinessRuleComposite>(filledComposites.values());
		System.out.println(converted);
		System.out.println("serviceprovider get size: " + converted.size());
		return converted;
	}
	
}
