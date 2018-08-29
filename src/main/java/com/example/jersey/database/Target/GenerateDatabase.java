package com.example.jersey.database.Target;

import org.json.JSONObject;

import java.sql.*;

public class GenerateDatabase extends DatabaseHelper_Target {



    public void generateBusinessRule(JSONObject object) throws Exception{
        switch (object.getString("type")){
            case "arr" : generateAttributeRangeRule(object); break;
            case "acr" : generateAttributeCompareRule(object); break;
            case "alr" : generateAttributeListRule(object); break;
            case "eor" : generateOtherRule(object); break;
            case "tcr" : generateTupleCompareRule(object); break;
            case "or" : generateOtherRule(object);break;
            case "iecr" : break;
        }
    }

    private String createTrigger(JSONObject object, String constraint){
        return "CREATE OR REPLACE TRIGGER " + object.getString("name") +
                " BEFORE INSERT OR UPDATE ON " + object.getString("table1") +
                " FOR EACH ROW " +
                "BEGIN " +
                constraint +
                " then RAISE_APPLICATION_ERROR (-20000, 'UPGRADE DENIED!'); " +
                " END IF; " +
                "END;";
    }

    private String createOtherTrigger(JSONObject object, String constraint) {
        return "CREATE OR REPLACE TRIGGER " + object.getString("name") + " " +
                "BEFORE INSERT OR UPDATE ON " + object.getString("table1") + " " +
                "FOR EACH ROW " +
                constraint;
    }

    public void generateAttributeRangeRule(JSONObject object) throws Exception{
        connect();
        Statement statement = connection.createStatement();
        String constrain = "IF NOT :NEW." + object.getString("column1") + " BETWEEN " + object.getInt("value1")+ " AND " + object.getInt("value2");
        statement.execute(createTrigger(object, constrain));
        disconnect();
    }

    public void generateAttributeCompareRule(JSONObject object) throws Exception{
        connect();
        Statement statement = connection.createStatement();
        String constraint =  "IF NOT :NEW." + object.getString("column1") + " " + object.getString("operator") + " " + object.getInt("value1");
        statement.execute(createTrigger(object, constraint));
        disconnect();
    }

    public void generateAttributeListRule(JSONObject object) throws Exception{ ;

        StringBuilder list = new StringBuilder();
        object.getJSONArray("value1").forEach(e->{
            list.append("'" +e + "',");
        });
        list.deleteCharAt(list.length() - 1);

        connect();
        Statement statement = connection.createStatement();
        String constraint = "IF NOT :NEW." + object.getString("column1") + " IN (" + list+ ")";
        statement.execute(createTrigger(object, constraint));

        disconnect();
    }

    public void generateOtherRule(JSONObject object) throws  Exception{
        connect();
        Statement statement = connection.createStatement();
        statement.execute(createOtherTrigger(object, object.getString("plsql")));
        disconnect();
    }

    public void generateTupleCompareRule(JSONObject object) throws Exception{
        connect();
        Statement statement = connection.createStatement();
        String constraint = "IF NOT :NEW." + object.getString("column1") + " " + object.getString("operator") + " :NEW." + object.getString("column2");
        statement.execute(createTrigger(object, constraint));
        disconnect();
    }
}
