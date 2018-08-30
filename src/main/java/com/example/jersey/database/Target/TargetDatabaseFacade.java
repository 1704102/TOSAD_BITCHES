package com.example.jersey.database.Target;

import org.json.JSONObject;

import java.util.ArrayList;

public class TargetDatabaseFacade {

    public void Generate(JSONObject object) throws Exception{
        new GenerateDatabase().generateBusinessRule(object);
    }

    public void activate(JSONObject object) throws Exception{
        new BusinessRuleDatabase().activateConstraint(object);
    }

    public void deactivate(JSONObject object) throws Exception{
        new BusinessRuleDatabase().deactivateConstraint(object);
    }

    public void delete(JSONObject object) throws Exception{
        new BusinessRuleDatabase().deleteConstraint(object);
    }

    public JSONObject getColumns(JSONObject object) throws Exception{
        return new TargetDatabase().getColumns(object);
    }

    public JSONObject getTables(JSONObject object) throws Exception{
        return new TargetDatabase().getTables(object);
    }

    public ArrayList<ArrayList<String>> getForeignkeys() throws Exception{
        TargetDatabase f = new TargetDatabase();
        ArrayList<ArrayList<String>> e= f.getForeignKeys();
        return e;
    }
}
