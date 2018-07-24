package com.example.jersey.domain;

public class CompareRule extends BusinessRuleComponent{
	
	private int value;
	private final Key<CompareRule> compare;
	private final String sql;
	
	public CompareRule (int value) {
		this.sql = "insert into (comparevalue) compare values(?)";
		this.compare = new Key<>("compare", CompareRule.class);
		this.value = value;
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

	@Override
	public String toString() {
		return "type: " + this.getComponentName() + " \n comparison: " + this.value;
	}

	@Override
	public Key<? extends CompareRule> getKey() {
		return compare;
	}

	@Override
	public String getSql() {
		return sql;
	}
	
}
