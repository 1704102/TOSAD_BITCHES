package com.example.jersey.dao;

import com.example.jersey.domain.BusinessRuleComponent;

public interface BusinessRuleComponentDao{
	// om te controleren of het component al bestaat
	public boolean exist(BusinessRuleComponent component);
	// saveComponent is a private method in CompositeDaoImpl
}
