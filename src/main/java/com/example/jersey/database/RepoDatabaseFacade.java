package com.example.jersey.database;

//
// Attribute Rules
//
import com.example.jersey.database.repository.DAO.AttributeCompareDao;
import com.example.jersey.database.repository.DAO.AttributeRangeDao;
import com.example.jersey.database.repository.DatabaseHelper_Repo;
import com.example.jersey.database.repository.UserDatabase;
//
// Tuple Rules
//
import com.example.jersey.database.repository.DAO.TupleCompareDaoImpl;
import com.example.jersey.database.repository.DAO.TupleOtherDaoImpl;

import org.json.JSONObject;

import java.util.ArrayList;

public class RepoDatabaseFacade{

    public void defineAttributeRangeRule(JSONObject object){
        AttributeRangeDao dao = new AttributeRangeDao();
        dao.define(object);
    }

    public JSONObject getAttributeRangeRule(JSONObject object){
        AttributeRangeDao dao = new AttributeRangeDao();
        return dao.get(object);
    }

    public void alterAttributeRangeRule(JSONObject object) {
        AttributeRangeDao dao = new AttributeRangeDao();
        dao.update(object);
    }

    public void deleteAttributeRangeRule(JSONObject object){
        AttributeRangeDao dao = new AttributeRangeDao();
        dao.delete(object);
    }

    public void defineAttributeCompareRule(JSONObject object){
        AttributeCompareDao dao = new AttributeCompareDao();
        dao.define(object);
    }

    public void alterAttributeCompareRule(JSONObject object) {
        AttributeCompareDao dao = new AttributeCompareDao();
        dao.update(object);
    }

    public void deleteAttributeCompareRule(JSONObject object){
        AttributeCompareDao dao = new AttributeCompareDao();
        dao.delete(object);
    }
    
    public void defineTupleCompareRule(JSONObject object) {
    	TupleCompareDaoImpl dao = new TupleCompareDaoImpl();
    	dao.define(object);
    }

    public void defineTupleOtherRule(JSONObject object) {
    	TupleOtherDaoImpl dao = new TupleOtherDaoImpl();
    	dao.define(object);
    }
    
        public boolean login(JSONObject object){
        UserDatabase database = new UserDatabase();
        return database.login(object);
    }


    public void register(JSONObject object) {
        UserDatabase database = new UserDatabase();
        database.register(object);
    }

    public void addDatabase(JSONObject object){
        UserDatabase database = new UserDatabase();
        database.addDatabase(object);
    }
}
