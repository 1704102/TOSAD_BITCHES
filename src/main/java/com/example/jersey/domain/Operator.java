package com.example.jersey.domain;

import java.util.ArrayList;
import java.util.List;

public class Operator extends BusinessRuleComponent {
	
	private String operator;
	
	public Operator(String operator) {
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
		List<String> operators = new ArrayList<String>();
		operators.add(new String("="));
		operators.add(new String("!="));
		
		operators.add(new String("<"));
		operators.add(new String(">"));
		
		operators.add(new String(">="));
		operators.add(new String("<="));
		
		if(operators.contains(operator)) {
			result = true;
		}	
		return result;
	}

	@Override
	public String toString() {
		return "type: " + this.getComponentName() + " \n operator: " + this.operator;
	}

}
