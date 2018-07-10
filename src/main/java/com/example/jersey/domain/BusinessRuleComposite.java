package com.example.jersey.domain;

import java.util.ArrayList;
import java.util.List;

// One single composite that will be used for building all 
public class BusinessRuleComposite {
	
	private String terminalExpression;
	private List<BusinessRuleComponent> children = new ArrayList<BusinessRuleComponent>();
	
	public BusinessRuleComposite(String terminalExpression) {
		
		this.terminalExpression = terminalExpression;
	}
	
	public void add(BusinessRuleComponent child) {
		this.children.add(child);
	}
	
//	public void remove(BusinessRuleComponent child) {
//		this.children.remove(child);
//	}
	
	public List<BusinessRuleComponent> getChildren(){
		return this.children;
	};
	
	// NOTE: use method during step one of life cycle
	public boolean interpretComposite() {
		return this.interpretComposite();
	}
	
	public String getTerminalExpression() {
		return this.terminalExpression;
	}
	
}
