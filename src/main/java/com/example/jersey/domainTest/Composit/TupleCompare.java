package com.example.jersey.domainTest.Composit;

import org.json.JSONObject;

import com.example.jersey.domainTest.Composit.Elements.Operator;

public class TupleCompare implements BusinessRuleComposite {

	private int id;
	
    private String table;
    private String columnOne;
    private String columnTwo;
    private Operator operator;
    
    public TupleCompare(int id, String table, String columnOne, String columnTwo, Operator operator) {
    	this.id = id;
    	this.table = table;
    	this.columnOne = columnOne;
    	this.columnTwo = columnTwo;
    	this.operator = operator;
    }
    
    public TupleCompare(String table, String columnOne, String columnTwo, Operator operator) {
    	this.table = table;
    	this.columnOne = columnOne;
    	this.columnTwo = columnTwo;
    	this.operator = operator;
    }
	
	@Override
	public String getRuleCode(String name) {
		return "alter table " + table +  " add constraint " + name + " check(" + columnOne + " " + operator.getValue() + " " + columnTwo + ") ENABLE NOVALIDATE";
	}

	@Override
	public String getName() {
		return table + "_CNS_TCR";
	}

	@Override
	public boolean validate() {
		if(!operator.validate()) return false;
		return true;
	}

	@Override
	public JSONObject getComposite() {
		JSONObject object = new JSONObject();
        object.put("id", id);
        object.put("table", table);
        object.put("columnOne", columnOne);
        object.put(columnTwo, columnTwo);
        object.put("operator", operator.getValue());
		return object;
	}

}
