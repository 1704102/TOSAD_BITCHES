package com.example.jersey.domainTest.Composit;

import org.json.JSONObject;

import com.example.jersey.domainTest.Composit.Elements.Constraint;

public class TupleOther implements BusinessRuleComposite{
	
	private int id;
	
    private String table;
    private String columnOne;
    private String columnTwo;
    private Constraint constraint; 
    
    public TupleOther(int id, String table, String columnOne, String columnTwo, Constraint constraint) {
    	this.id = id;
    	this.table = table;
    	this.columnOne = columnOne;
    	this.columnTwo = columnTwo;
    	this.constraint = constraint;
    	
    }

	@Override
	public String getRuleCode(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public JSONObject getComposite() {
		// TODO Auto-generated method stub
		return null;
	}
    
    
}
