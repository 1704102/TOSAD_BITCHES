package com.example.jersey.dao.impl;

import java.sql.Connection;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BaseDao {
	protected final Connection getConnection() {
		Connection result = null;

		try {
			InitialContext ic = new InitialContext();
			DataSource datasource = (DataSource) ic.lookup("java:comp/env/jdbc/PostgresDS");
			
			result = datasource.getConnection();
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
		
		return result;
	}
	
}
