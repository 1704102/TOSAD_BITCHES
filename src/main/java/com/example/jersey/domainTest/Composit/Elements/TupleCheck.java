package com.example.jersey.domainTest.Composit.Elements;

public class TupleCheck implements ConstraintCheck{
	
	private String columnOne;
	private String columnTwo;
	private Operator operator;
	
	private TupleCheck(String columnOne, String ColumnTwo, Operator operator) {
		this.columnOne = columnOne;
		this.columnTwo = columnTwo;
		this.operator = operator;
	}
	
	@Override
	public boolean validate() {
		return true;
	}

	@Override
	public String getCheck() {
		return this.columnOne + " " + this.operator + " " + this.columnTwo;
	}

}
