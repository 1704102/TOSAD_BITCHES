package com.example.jersey.domain;


public interface BusinessRuleComponent<T> {
	// interpret the type of component
	public String getComponentName();
}
