package com.example.jersey.domain;

import java.util.List;

// One single composite that will be used for building all 
public class BusinessRuleComposite {
	private String terminalExpression;
	private List<BusinessRuleComponent> children;
	
	public BusinessRuleComposite(String terminalExpression
			, List<BusinessRuleComponent> components) {
		this.terminalExpression = terminalExpression;
		this.children = components;
	}
	
	public void add(BusinessRuleComponent child) {
		this.children.add(child);
	}
	
	public void remove(BusinessRuleComponent child) {
		this.children.remove(child);
	}
	public List<BusinessRuleComponent> getChildren(){
		return this.children;
	};
	// hardcoded type. Next version will issue how to persist all types dynamically
	private boolean interpret(){
		boolean result = false;
		for(BusinessRuleComponent child : this.getChildren() ) {
			// 2. determine the type of business rule by interpreting the code
			if(child.getComponentName().contains("ACMP"
					)) {
				// 2.1 persist type into composite 
				this.terminalExpression = "ACMP";
				result = true;
				break; // for now
			} 
		}
		
		return result;
	}
	
	// NOTE: use method during step one of life cycle
	public boolean interpretComposite() {
		return this.interpretComposite();
	}
	
	public String getTerminalExpression() {
		return this.terminalExpression;
	}
}
