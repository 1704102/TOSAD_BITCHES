package com.example.jersey.domainTest.Composit.Elements;

import java.util.ArrayList;
import java.util.Arrays;

// this is adapted from: https://www.geeksforgeeks.org/enum-in-java/

public class Constraint {
	
	private ArrayList<String> types = new ArrayList<String>(Arrays.asList(
		"NOT NULL",
		"UNIQUE",
		"PRIMARY KEY", 
		"FOREIGN KEY",
		"CHECK", // only fit for attribute other rule
		"DEFAULT", // Sets a default value for a column when no value is specified
		"INDEX" // Used to create and retrieve data from the database very quickly
	));
	
	private String statement;
	private String type;
	private String variable;
	private Operator operator;
	
	public Constraint (String type, String table, String column) {
		this.type = type;
		//
		// because only tupleother has constraints only. 
		// entityother and attribute other doesnt have constraints
		//
		statementIsLike(table, column);
	}
	
	//
	//
	//
	public Constraint (String type, String table, String column, Operator operator) {
		this.type = type;
		//
		// because only tupleother has constraints only. 
		// entityother and attribute other doesnt have constraints
		//
		statementIsLike(table, column);
	}
	
	private void statementIsLike(String table, String column) {
		String base = "ALTER TABLE " + table;
		switch (this.type) {
			case "NOT NULL":
			case "UNIQUE":
				this.statement = base + "MODIFY COLUMN " + column + "UNIQUE";
				break;
			case "PRIMARY KEY":
			case "FOREIGN KEY":
				this.statement = base + "ADD CONSTRAINT fk_" + column
				+ this.type + "(" + column + ")" +
				"REFERENCES " + table + "(" + column + ")";
				break;
			case "DEFAULT":
				// 
				// should be in frontend to as an option to define a default value
				// for the specified column
				// 
				this.statement = base + "ADD DEFAULT " + variable;
				break;
			case "CHECK":
				this.statement = base + "MODIFY " + "(" + variable + ")";
				break;
		}
	}
	
	public String getValue() {
		return this.statement;
	}
	
}
