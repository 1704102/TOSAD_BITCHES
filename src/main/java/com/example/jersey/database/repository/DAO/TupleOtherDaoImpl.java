package com.example.jersey.database.repository.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.json.JSONArray;
import org.json.JSONObject;

import com.example.jersey.database.repository.DatabaseHelper_Repo;

public class TupleOtherDaoImpl extends DatabaseHelper_Repo implements BusinessRuleDao {

	@Override
	public JSONArray getAll(JSONObject object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JSONObject get(JSONObject object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void define(JSONObject object) {
		try {
			connect();
            PreparedStatement statement = connection.prepareStatement("insert into TUPLECOMPARE (ID, TABLE1, COLUMN1, COLUMN2) values (?, ?, ?, ?)");
            //
            // NOTE: What is this supposed to be?
            //
            //statement.setInt(1,1); 
            statement.setInt(1, object.getInt("id"));
            statement.setString(2, object.getString("table"));
            statement.setString(3, object.getString("columnOne"));
            statement.setString(4, object.getString("columnTwo"));
            statement.setString(5, object.getString("constraint"));
            //
            // NOTE: why isn't define a boolean? then you can just check if the transaction succeeded
            //
            System.out.println(
            "TupleCompareDaoImpl between line 51 and 53 \n" + 
            "this is a good way to check if define is: "
            + statement.execute() );
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(JSONObject object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(JSONObject object) {
		// TODO Auto-generated method stub
		
	}

}
