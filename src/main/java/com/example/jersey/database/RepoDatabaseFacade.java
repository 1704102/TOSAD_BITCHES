package com.example.jersey.database;

import com.example.jersey.database.repository.DAO.attribute.AttributeCompareDao;
import com.example.jersey.database.repository.DAO.attribute.AttributeListDao;
import com.example.jersey.database.repository.DAO.attribute.AttributeOtherDao;
import com.example.jersey.database.repository.DAO.attribute.AttributeRangeDao;
import com.example.jersey.database.repository.DAO.tuple.TupleCompareDao;
import com.example.jersey.database.repository.DAO.tuple.TupleOtherDao;
import com.example.jersey.database.repository.DatabaseHelper_Repo;
import com.example.jersey.database.repository.UserDatabase;
import org.json.JSONObject;

import javax.xml.crypto.Data;

public class RepoDatabaseFacade {

    //<editor-fold desc="AttributeRangeRule">
    public void defineAttributeRangeRule(JSONObject object) throws Exception{
        AttributeRangeDao dao = new AttributeRangeDao();
        dao.define(object);
    }
    public JSONObject getAllAttributeRangeRules(JSONObject object) throws Exception {
        AttributeRangeDao dao = new AttributeRangeDao();
        return dao.getAll(object);
    }
    public JSONObject getAttributeRangeRule(JSONObject object) throws Exception{
        AttributeRangeDao dao = new AttributeRangeDao();
        return dao.get(object);
    }
    public void alterAttributeRangeRule(JSONObject object) throws Exception {
        AttributeRangeDao dao = new AttributeRangeDao();
        dao.update(object);
    }
    //</editor-fold>
    //<editor-fold desc="AttributeCompareRule">
    public void defineAttributeCompareRule(JSONObject object) throws Exception{
        AttributeCompareDao dao = new AttributeCompareDao();
        dao.define(object);
    }
    public Object getAttributeCompareRule(JSONObject object) throws Exception {
        AttributeCompareDao dao = new AttributeCompareDao();
        return dao.get(object);
    }
    public JSONObject getAllAttributeCompareRules(JSONObject object) throws Exception {
        AttributeCompareDao dao = new AttributeCompareDao();
        return dao.getAll(object);
    }
    public void alterAttributeCompareRule(JSONObject object) throws Exception {
        AttributeCompareDao dao = new AttributeCompareDao();
        dao.update(object);
    }
    //</editor-fold>
    //<editor-fold desc="AttributeListRule">
    public void defineAttributeListRule(JSONObject object) throws Exception{
        AttributeListDao dao = new AttributeListDao();
        dao.define(object);
    }
    public JSONObject getAllAttributeListRules(JSONObject object) throws Exception {
        AttributeListDao dao = new AttributeListDao();
        return dao.getAll(object);
    }
    public JSONObject getAttributeListRule(JSONObject object) throws Exception {
        AttributeListDao dao = new AttributeListDao();
        return dao.get(object);
    }
    public void alterAttributeListRule(JSONObject object) throws Exception {
        AttributeListDao dao = new AttributeListDao();
        dao.update(object);
    }
    //</editor-fold>
    //<editor-fold desc="AttributeOtherRule">
    public void defineAttributeOtherRule(JSONObject object) throws Exception {
        AttributeOtherDao dao = new AttributeOtherDao();
        dao.define(object);
    }
    public void alterAttributeOtherRule(JSONObject object) throws Exception {
        TupleOtherDao dao = new TupleOtherDao();
        dao.update(object);
    }
    public JSONObject getAllAttributeOtherRules(JSONObject object) throws Exception{
        TupleOtherDao dao = new TupleOtherDao();
        return dao.getAll(object);
    }

    public JSONObject getAttributeOtherRule(JSONObject object) throws Exception{
        TupleOtherDao dao = new TupleOtherDao();
        return dao.get(object);
    }
    //<editor-fold>
    //<editor-fold desc="TupleCompare">
    public void defineTupleCompareRule(JSONObject object) throws Exception {
        TupleCompareDao dao = new TupleCompareDao();
        dao.define(object);
    }
    public void alterTupleCompareRule(JSONObject object) throws Exception {
        TupleCompareDao dao = new TupleCompareDao();
        dao.update(object);
    }
    public JSONObject getAllTupleCompareRules(JSONObject object) throws Exception{
        TupleCompareDao dao = new TupleCompareDao();
        return dao.getAll(object);
    }

    public JSONObject getTupleCompareRule(JSONObject object) throws Exception{
        TupleCompareDao dao = new TupleCompareDao();
        return dao.get(object);
    }
    //</editor-fold>
    //<editor-fold desc="TupleOther">
    public void defineTupleOtherRule(JSONObject object) throws Exception {
        TupleOtherDao dao = new TupleOtherDao();
        dao.define(object);
    }
    public void alterTupleOtherRule(JSONObject object) throws Exception {
        TupleOtherDao dao = new TupleOtherDao();
        dao.update(object);
    }
    public JSONObject getAllTupleOtherRules(JSONObject object) throws Exception{
        TupleOtherDao dao = new TupleOtherDao();
        return dao.getAll(object);
    }

    public JSONObject getTupleOtherRule(JSONObject object) throws Exception{
        TupleOtherDao dao = new TupleOtherDao();
        return dao.get(object);
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

    public void deleteRule(JSONObject object) throws Exception{
        DatabaseHelper_Repo repo = new DatabaseHelper_Repo();
        repo.deleteRule(object);
    }
}
