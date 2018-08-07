package com.example.jersey.domainTest.Composit.Elements;

public class ValueCheck implements ConstraintCheck {
	private String column;
	private String value;
	private Operator operator;
	
	public ValueCheck (String column, String value, Operator operator) {
		this.column = column;
		this.value = value;
		this.operator = operator;
	}

	@Override
	public boolean validate() {
		return true;
	}

	@Override
	public String getCheck() {
		return this.column + " " + this.operator + " " + this.value;
	}
	
}
