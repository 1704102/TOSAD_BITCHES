package com.example.jersey.domain;

public class ConstraintRule extends BusinessRuleComponent{
	private String constraint;
	private final Key<ConstraintRule> constraintKey;
	private final String sql;
	
	public ConstraintRule(String constraint) {
		this.sql = "insert into (value) constraint values (?)";
		this.constraintKey = new Key<>("constraint",ConstraintRule.class);
		this.constraint = constraint;
	}

	@Override
	public String getComponentName() {
		return "constraint";
	}

	@Override
	public String toString() {
		return "constraint: " + this.constraint;
	}

	@Override
	public Key<? extends ConstraintRule> getKey() {
		return constraintKey;
	}

	@Override
	public String getSql() {
		return sql;
	}
}
