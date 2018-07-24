package com.example.jersey.domain;

import java.util.ArrayList;
import java.util.List;

public class Operator extends BusinessRuleComponent {
	
	private String operator;
	private final Key<Operator> value;
	private final List<String> operators;
	private final String sql;
	
	public Operator(String operator) {
		this.sql = "insert into (value) businessrule_component values(?)";
		this.value = new Key<>("value", Operator.class);
		this.operators = new ArrayList<String>();
			operators.add(new String("="));
			operators.add(new String("!="));
			
			operators.add(new String("<"));
			operators.add(new String(">"));
			
			operators.add(new String(">="));
			operators.add(new String("<="));
		this.operator = operator;
	}
	
	public String getOperator() {
		return this.operator;
	}
	
	@Override
	public String getComponentName() {
		String result = "invalid-operator";
		if (validateOperator(this.operator)) {
			result = "valid-operator";
		}
		return result;
	}
	
	private boolean validateOperator(String operator) {
		boolean result = false;
		if(operators.contains(operator)) {
			result = true;
		}	
		return result;
	}

	@Override
	public String toString() {
		return "type: " + this.getComponentName() + " \n operator: " + this.operator;
	}

	@Override
	public Key<? extends Operator> getKey() {
		return value;
	}

	@Override
	public String getSql() {
		return sql;
	}

}
