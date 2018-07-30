package com.example.jersey.database;

import com.example.jersey.database.repository.DAO.AttributeCompareDao;
import com.example.jersey.database.repository.DAO.AttributeRangeDao;
import com.example.jersey.database.repository.DatabaseHelper_Repo;
import org.json.JSONObject;

import java.util.ArrayList;

public class DatabaseFacade{

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


}
