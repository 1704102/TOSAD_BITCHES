package com.example.jersey.domainTest.Composit.Elements;

public class RangeCheck implements ConstraintCheck{
	private String minimum;
	private String maximum;
	
	public RangeCheck(String minimum, String maximum) {
		this.minimum = minimum;
		this.maximum = maximum;
	}
	
	@Override
	public boolean validate() {
		if(Integer.parseInt(this.minimum) >= 
			Integer.parseInt(this.maximum) ) return false;
		return true;
	}

	@Override
	public String getCheck() {
		return "BETWEEN " + this.minimum + " AND " + this.maximum;
	}
	 
}
