package com.example.jersey.database.repository.DAO;

import com.example.jersey.database.repository.DatabaseHelper_Repo;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;

public interface BusinessRuleDao{

    JSONObject getAll(JSONObject object) throws Exception;
    JSONObject get(JSONObject object) throws Exception;
    void define(JSONObject object) throws Exception;
    void update(JSONObject object) throws Exception;
    void delete(JSONObject object) throws Exception;
    int getInitId() throws Exception;
}
