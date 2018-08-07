package com.example.jersey.database.repository.DAO;

import com.example.jersey.database.repository.DatabaseHelper_Repo;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;

public interface BusinessRuleDao{

    JSONArray getAll(JSONObject object);
    JSONObject get(JSONObject object);
    void define(JSONObject object);
    void update(JSONObject object);
    void delete(JSONObject object);
}
