package com.example.jersey.database.repository;

import com.example.jersey.database.repository.DAO.BusinessRuleDao;
import com.example.jersey.database.repository.DAO.attribute.AttributeCompareDao;
import com.example.jersey.database.repository.DAO.attribute.AttributeListDao;
import com.example.jersey.database.repository.DAO.attribute.AttributeRangeDao;
import com.example.jersey.database.repository.DAO.other.OtherRuleDao;
import com.example.jersey.database.repository.DAO.tuple.TupleCompareDao;
import org.json.JSONObject;

public class RepoDatabaseFacade {

    public JSONObject getRule(JSONObject object, String type) throws Exception{
        BusinessRuleDao dao = getDao(type);
        return dao.get(object);
    }

    public JSONObject getRules(JSONObject object, String type) throws Exception{
        BusinessRuleDao dao = getDao(type);
        return dao.getAll(object);
    }

    public void defineRule(JSONObject object, String type) throws Exception{
        BusinessRuleDao dao = getDao(type);
        dao.define(object);
    }

    public void updateRule(JSONObject object, String type) throws Exception{
        BusinessRuleDao dao = getDao(type);
        dao.update(object);
    }

    private BusinessRuleDao getDao(String type){
        switch (type){
            case "arr" : return new AttributeRangeDao();
            case "acr" : return new AttributeCompareDao();
            case "alr" : return new AttributeListDao();
            case "tcr" : return new TupleCompareDao();
            case "or" : return new OtherRuleDao();
            default : return null;
        }
    }

    public void deleteRule(JSONObject object) throws Exception{
        DatabaseHelper_Repo repo = new DatabaseHelper_Repo();
        repo.deleteRule(object);
    }

    public void activate(JSONObject object) throws Exception{
        new DatabaseHelper_Repo().activate(object);
    }

    public void deactivate(JSONObject object) throws Exception{
        new DatabaseHelper_Repo().deactivate(object);
    }
}
