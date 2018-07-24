package com.example.jersey.domain;

public class AttributeRule extends BusinessRuleComponent{

	private String attribute;
	private final Key<AttributeRule> attributeKey;
	private final String sql;
	
	public AttributeRule(String attribute) {
		this.sql = "insert into (columnname) attribute values(?)";
		this.attribute = attribute;
		this.attributeKey = new Key<>("column", AttributeRule.class);
	}
	
	public String getAttribute() {
		return this.attribute;
	}

	@Override
	public String getComponentName() {
		// - decorator for matching the right businessrule name 
		/* 
		 * Must haves: 
		Attribute compare rule 
		Attribute range rule
		 * Should haves
		Attibrute List Rule
		*/
		return "attribute";
	}
	
	public String toString() {
		return "name: " + this.getAttribute() + "\n ruleType:" + this.getComponentName();
	}

	@Override
	public Key<? extends AttributeRule> getKey() {
		return attributeKey;
	}

	@Override
	public String getSql() {
		return sql;
	}
}
