package com.example.jersey.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// One single composite that will be used for building all composites
public class BusinessRuleComposite {

	private String terminalExpression;
	private List<BusinessRuleComponent> children = new ArrayList<BusinessRuleComponent>();
	
	
	// NOTE: type safety strategy explained below
	// - typed tokens as key
	// - components "has" children that can be identified separately
	private final Map<Key<?>,Object> components = new HashMap<>();
	
	public BusinessRuleComposite(String terminalExpression) {
		this.terminalExpression = terminalExpression;
	}
	
	public void add(BusinessRuleComponent child) {
		this.children.add(child);
	}
	
	// will be implemented soon if I can find a way to add subtypes with the
	// heterogeneous container pattern: https://www.codeaffine.com/2015/03/04/map-distinct-value-types-using-java-generics/
	  public <T> void put( Key<T> key1, BusinessRuleComponent component1 ) {
	    components.put( key1, component1 );
	  }
	
	public <T> T getSubtype(Key<T> key) {
		return key.type.cast( components.get( key ));
	}
	
	// NOTE: reissue usefulness
	public List<BusinessRuleComponent> getChildren(){
		return this.children;
	};
	
	public String getTerminalExpression() {
		return this.terminalExpression;
	}
}
