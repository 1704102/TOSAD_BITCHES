package com.example.jersey.database;

import com.example.jersey.database.repository.DAO.AttributeCompareDao;
import com.example.jersey.database.repository.DAO.AttributeListDao;
import com.example.jersey.database.repository.DAO.AttributeRangeDao;
import com.example.jersey.database.repository.UserDatabase;
import com.example.jersey.domainTest.Composit.AttributeList;
import org.json.JSONObject;

public class RepoDatabaseFacade {

    //<editor-fold desc="AttributeRangeRule">
    public void defineAttributeRangeRule(JSONObject object){
        AttributeRangeDao dao = new AttributeRangeDao();
        dao.define(object);
    }
    public Object getAllAttributeRangeRules() {
        AttributeRangeDao dao = new AttributeRangeDao();
        return dao.getAll();
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

    //</editor-fold>
    //<editor-fold desc="AttributeCompareRule">
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

    //</editor-fold>
    //<editor-fold desc="AttributeListRule">
    public void defineAttributeListRule(JSONObject object) {
        AttributeListDao dao = new AttributeListDao();
        dao.define(object);
    }
    public JSONObject getAttributeListRule(JSONObject object) {
        AttributeListDao dao = new AttributeListDao();
        return dao.get(object);
    }
    public void alterAttributeListRule(JSONObject object) {
        AttributeListDao dao = new AttributeListDao();
        dao.update(object);
    }
    public void deleteAttributeListRule(JSONObject object) {
        AttributeListDao dao = new AttributeListDao();
        dao.delete(object);
    }
    //</editor-fold>
    //<editor-fold desc="User">
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


    //</editor-fold>

}
