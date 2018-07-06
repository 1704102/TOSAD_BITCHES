package com.example.jersey.domain;

public class CompareRule implements BusinessRuleComponent<CompareRule>{
	
	private String compareA;
	
	public CompareRule (String compareA) {
		this.compareA = compareA;
	}
	
	public String getCompareA() {
		return this.compareA;
	}
	
	@Override
	public String getComponentName() {
		// - helper for matching the right businessrule name 
		/* 
		 * Must haves: 
		Attribute compare rule 
		Attribute range rule
		 * Should haves
		Attibrute List Rule
		*/
		return "compare";
	}
	
}
