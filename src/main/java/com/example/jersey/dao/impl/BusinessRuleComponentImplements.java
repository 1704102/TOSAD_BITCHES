package com.example.jersey.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.example.jersey.dao.BusinessRuleComponentDao;
import com.example.jersey.domain.AttributeRule;
import com.example.jersey.domain.BusinessRuleComponent;

public class BusinessRuleComponentImplements extends BaseDao
implements BusinessRuleComponentDao{
	
	// 1. check if similar entities exist
	@Override
	public boolean exist(BusinessRuleComponent persist) {
		boolean result = false;
		try(Connection con = super.getConnection()){
			String statement = "";
			// 1.1. how do I match the best result? determine the type
			statement += "SELECT * FROM businessrule where something = ?";
			PreparedStatement pstmt = con.prepareStatement(statement);
			pstmt.setString(1, "something");
			
			ResultSet rs = pstmt.executeQuery();
			// 1.2. retrieve the component after matches are found
			while(rs.next()) {
				String something = rs.getString("something");
				String somethingElse = rs.getString("somethingElse");
				
				// 1.3. vergelijk de opgehaalde types om een duplicaat te vinden
				BusinessRuleComponent data = new AttributeRule(something);
				if (data.equals(persist)) {
					return true;
				}
			}
			pstmt.close();
			rs.close();
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return true;
		
	}

}
