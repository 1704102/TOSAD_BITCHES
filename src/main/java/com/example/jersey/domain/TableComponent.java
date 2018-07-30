package com.example.jersey.domain;

public class TableComponent extends BusinessRuleComponent {
	
	private String table;
	private final Key<TableComponent> tablecomp;
	private final String sql;
	
	public TableComponent(String table) {
		this.sql = "insert into (tablecolumn) table values (?)";
		this.tablecomp = new Key<>("table",TableComponent.class);
		this.table = table;
	}
	
	@Override
	public String getComponentName() {
		return "tablecomponent";
	}

	@Override
	public String toString() {
		return "table: " + this.table;
	}

	@Override
	public Key<? extends BusinessRuleComponent> getKey() {
		return tablecomp;
	}

	@Override
	public String getSql() {
		// TODO Auto-generated method stub
		return sql;
	}
	
}
