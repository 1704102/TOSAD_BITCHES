package com.example.jersey.database;

import com.example.jersey.database.repository.DAO.AttributeRangeDao;
import com.example.jersey.database.repository.DatabaseHelper_Repo;
import org.json.JSONObject;

import java.util.ArrayList;

public class DatabaseFacade{

    public void defineAttributeRangeRule(JSONObject object){
        AttributeRangeDao dao = new AttributeRangeDao();
        dao.define(object);
    }
}
