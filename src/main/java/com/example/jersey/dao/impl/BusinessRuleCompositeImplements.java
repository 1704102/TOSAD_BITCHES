package com.example.jersey.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map.Entry;

import com.example.jersey.Visitor.RuleDefinitions;
import com.example.jersey.dao.BusinessRuleCompositeDao;
import com.example.jersey.domain.BusinessRuleComponent;
import com.example.jersey.domain.BusinessRuleComposite;
import com.example.jersey.domain.Key;

public class BusinessRuleCompositeImplements extends BaseDao implements BusinessRuleCompositeDao{
	private static final RuleDefinitions ruleDefinitions = new RuleDefinitions();
	
	//
	// 3. save Composite
	//
	
	@Override
	public boolean saveComposite(BusinessRuleComposite composite) {
		
		//
		// Functional requirements:
		// - saveComposite Needs to pick the matching statements
		// - what else? let me know!
		//
		
		int result = 0;
		
		try(Connection con = super.getConnection()){
			String statementOne = "INSERT INTO (name) businessrule VALUES ?";
			
			//
			// 3.1. retrieve the stored sequel statements from ...
			//
			
			List<String> entries = ruleDefinitions.getComponentStatements(composite);
			
			//
			// NOTE: only applicable for the following types:
			// > attribute- and tuple compareRule
			//
			
			for (Entry<Key<? extends BusinessRuleComponent>, BusinessRuleComponent> entry : composite.getHashedChildren().entrySet()){
				BusinessRuleComponent component = (BusinessRuleComponent) entry.getValue();
			
			};
			
			PreparedStatement pstmt = con.prepareStatement(statementOne);
			pstmt.setString(1, composite.getTerminalExpression());
			
			result = pstmt.executeUpdate();
		
		} catch( Exception e) {
			e.printStackTrace();
		
		}
		return result >= 1;
		
	}

	private boolean saveComponent(BusinessRuleComponent brc, String componentStatement) throws SQLException {
		int result = 0;
		try(Connection con = super.getConnection()){
			PreparedStatement pstmt = con.prepareStatement(componentStatement);
			
			//
			// can be made more generic
			//
			
			pstmt.setString(1, brc.getComponentName());
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return result >= 1;
	}

}
