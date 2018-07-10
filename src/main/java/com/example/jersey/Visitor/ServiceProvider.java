package com.example.jersey.Visitor;

public class ServiceProvider {
	private static DefineBusinessRuleService service = new DefineBusinessRuleService();
	
	public static DefineBusinessRuleService getDefineBusinessRuleService() {
		return service;
	}
}
