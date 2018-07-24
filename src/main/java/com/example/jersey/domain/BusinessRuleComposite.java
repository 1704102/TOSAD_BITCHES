
package com.example.jersey.domain;

// #001: just to show if saving types can be made more accessable 

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

// One single composite that will be used for building all composites
public class BusinessRuleComposite {

	private String terminalExpression;
	private List<BusinessRuleComponent> children = new ArrayList<BusinessRuleComponent>();
	
	// NOTE: type safety strategy explained below
	// - typed tokens as key
	// - components "has" children that can be identified separately
	private final Map<Key<? extends BusinessRuleComponent>, BusinessRuleComponent> components = new HashMap<>();
	
	public BusinessRuleComposite(String terminalExpression) {
		this.terminalExpression = terminalExpression;
	}
	
	//	public void addKey
	
	public void add(BusinessRuleComponent child) {
		this.children.add(child);
	}
	// extends Key<BusinessRuleComponent>
	public boolean confirm(Set<?> keys) {
		// REFACTOR: how to check if all items are the expected type?
		if (this.components == null || keys == null) {
			System.out.println("confirm: null");
			return false;
		}
		else if (components.size() != keys.size()) {
			System.out.println("confirm: not the same size");
			return false;
		} else {
			Set<?> self = this.components.keySet();
			return self.containsAll(keys) && keys.containsAll(self);
		}
	}
	
	// will be implemented soon if I can find a way to add subtypes with the
	// heterogeneous container pattern: https://www.codeaffine.com/2015/03/04/map-distinct-value-types-using-java-generics/
	public <T> void put( Key<? extends BusinessRuleComponent> key1, BusinessRuleComponent component1 ) {
		this.components.put( key1, component1 );
	}
	
	public <T> T getSubtype(Key<T> key) {
		return key.type.cast( components.get( key ));
	}
	
	public Map<Key<? extends BusinessRuleComponent>,BusinessRuleComponent> getHashedChildren() {
		return components;
	}
	
	// NOTE: reissue usefulness
	public List<BusinessRuleComponent> getChildren(){
		return this.children;
	};
	
	public String getTerminalExpression() {
		return this.terminalExpression;
	}
}
