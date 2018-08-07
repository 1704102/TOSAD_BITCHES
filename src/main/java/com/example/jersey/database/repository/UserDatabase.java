package com.example.jersey.database.repository;

import org.json.JSONObject;

public class UserDatabase extends DatabaseHelper_Repo{

    public boolean login(JSONObject object){
        //TODO login code
        return true;
    }

    public void register(JSONObject object) {
        //TODO register code
    }

    public void addDatabase(JSONObject object){
        //TODO add database to repo code
    }

    public JSONObject getDatabases(JSONObject object){
        //TODO get Databases from user
        return new JSONObject();
    }

    public JSONObject getDatabase(JSONObject object){
        //TODO get Databases from user
        return new JSONObject();
    }


}
