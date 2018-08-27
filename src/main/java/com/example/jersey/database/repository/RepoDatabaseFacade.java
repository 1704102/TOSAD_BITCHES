package com.example.jersey.database.repository;

import com.example.jersey.database.repository.DAO.BusinessRuleDao;
import com.example.jersey.database.repository.DAO.attribute.AttributeCompareDao;
import com.example.jersey.database.repository.DAO.attribute.AttributeListDao;
import com.example.jersey.database.repository.DAO.attribute.AttributeOtherDao;
import com.example.jersey.database.repository.DAO.attribute.AttributeRangeDao;
import com.example.jersey.database.repository.DAO.entity.EntityOtherDao;
import com.example.jersey.database.repository.DAO.tuple.TupleCompareDao;
import com.example.jersey.database.repository.DAO.tuple.TupleOtherDao;
import com.example.jersey.database.repository.DatabaseHelper_Repo;
import org.json.JSONObject;

import javax.xml.crypto.Data;

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
            case "aor" : return new AttributeOtherDao();
            case "tcr" : return new TupleCompareDao();
            case "tor" : return new TupleOtherDao();
            case "eor" : return new EntityOtherDao();
            default : return null;
        }
    }

    public void deleteRule(JSONObject object) throws Exception{
        DatabaseHelper_Repo repo = new DatabaseHelper_Repo();
        repo.deleteRule(object);
    }
}
