package com.example.jersey.domain;


public abstract class BusinessRuleComponent {
	// interpret the type of component
	public abstract String getComponentName();
	public abstract String toString();
	public abstract String getSql();
	public abstract Key<? extends BusinessRuleComponent> getKey();
}
