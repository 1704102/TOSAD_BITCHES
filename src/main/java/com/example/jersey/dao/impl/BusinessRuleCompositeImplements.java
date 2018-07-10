package com.example.jersey.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.example.jersey.dao.BusinessRuleCompositeDao;
import com.example.jersey.domain.BusinessRuleComponent;
import com.example.jersey.domain.BusinessRuleComposite;

public class BusinessRuleCompositeImplements extends BaseDao implements BusinessRuleCompositeDao{

	// 3. save Composite
	@Override
	public boolean saveComposite(BusinessRuleComposite composite) {
		// Functional requirements:
		// - saveComposite Needs to pick the matching statements
		// - what else? let me know!
		int result = 0;
		try(Connection con = super.getConnection()){
			String statementOne = "INSERT INTO (name) businessrule VALUES";
			// 2.1 save the components first
			for (BusinessRuleComponent component : composite.getChildren()){
				if ( !saveComponent(component)) {
					System.out.println("oops!: step 1 didn't go as expected");
					
					break;
				}
			};
			statementOne += "";
			
			PreparedStatement pstmt = con.prepareStatement(statementOne);
			pstmt.setString(1, "uhh???");
			
			result = pstmt.executeUpdate();
		
		} catch( Exception e) {
			e.printStackTrace();
		}
		return result >= 1;
		
	}

	// 
	private boolean saveComponent(BusinessRuleComponent brc) throws SQLException {
		int result = 0;
		try(Connection con = super.getConnection()){
			// tablecomponents
			// - attribute
			// - compare
			// more coming soon
			String statement = "INSERT INTO ";
			switch (brc.getComponentName()) {
			case "attribute" : 
				statement += "(name) attributerule VALUES (?)"; 
				break;
			case "compare" : 
				statement += "(compareA) comparerule VALUES (?)"; 
				break;
			default : return false;
			}
			
			PreparedStatement pstmt = con.prepareStatement(statement);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return result >= 1;
	}

}
