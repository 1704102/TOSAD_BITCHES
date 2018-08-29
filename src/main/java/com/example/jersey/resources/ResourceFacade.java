package com.example.jersey.resources;

import com.example.jersey.database.Target.TargetDatabaseFacade;
import com.example.jersey.database.repository.RepoDatabaseFacade;
import com.example.jersey.database.Target.GenerateDatabase;
import com.example.jersey.domainTest.DomainFacade;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Arrays;

public class ResourceFacade {

    DomainFacade domainFacade = new DomainFacade();
    RepoDatabaseFacade repoDatabaseFacade = new RepoDatabaseFacade();
    TargetDatabaseFacade targetDatabaseFacade = new TargetDatabaseFacade();

    public Response getRule(JSONObject object, String type){
        try {
            return Response.ok(repoDatabaseFacade.getRule(object, type).toString(), MediaType.APPLICATION_JSON).build();
        }catch (Exception e){
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
    }

    public Response getRules(JSONObject object, String type){
        try {
            return Response.ok(repoDatabaseFacade.getRules(object, type).toString(), MediaType.APPLICATION_JSON).build();
        }catch (Exception e){
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
    }

    public Response defineRule(JSONObject object, String type){
        try {
            repoDatabaseFacade.defineRule(domainFacade.defineRule(object , type), type);
            return Response.ok("{\"response\":\" rule added to database \"}", MediaType.APPLICATION_JSON).build();
        }catch (Exception e){
            e.printStackTrace();
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
    }

    public Response updateRule(JSONObject object, String type){
        try {
            //TODO only send rule_id composite_id type
            repoDatabaseFacade.updateRule(object, type);
            return Response.ok("{\"response\":\" rule updated in database \"}", MediaType.APPLICATION_JSON).build();
        }catch (Exception e){
            e.printStackTrace();
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
    }

    public Response generate(JSONObject object) {
        GenerateDatabase database = new GenerateDatabase();
        try {
            database.generateBusinessRule(repoDatabaseFacade.getRule(object, object.getString("type")));
        }catch (Exception e){
            e.printStackTrace();
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
        return Response.ok("{\"message\":\"rule generated\"}", MediaType.APPLICATION_JSON).build();
    }

    public Response deleteBusinessRule(JSONObject object){
        try {
            targetDatabaseFacade.delete(object);
            repoDatabaseFacade.deleteRule(object);
        }catch (Exception e){
            e.printStackTrace();
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
        return Response.ok("{\"message\":\"rule deleted\"}", MediaType.APPLICATION_JSON).build();
    }

    public Response activateRule(JSONObject object){
        try {
            targetDatabaseFacade.activate(object);
            repoDatabaseFacade.activate(object);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Response.ok("{\"message\":\"rule activated\"}", MediaType.APPLICATION_JSON).build();
    }

    public Response deactivateRule(JSONObject object){
        try {
            targetDatabaseFacade.deactivate(object);
            repoDatabaseFacade.deactivate(object);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Response.ok("{\"message\":\"rule deactivated\"}", MediaType.APPLICATION_JSON).build();
    }

    public Response getColumns(JSONObject object){
        try {
            return Response.ok(targetDatabaseFacade.getColumns(object).toString(), MediaType.APPLICATION_JSON).build();
        }catch (Exception e){
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
    }

    public Response getTables(JSONObject object) {
        try {
            return Response.ok(targetDatabaseFacade.getTables(object).toString(), MediaType.APPLICATION_JSON).build();
        }catch (Exception e){
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
    }

    public Response getAll(JSONObject object) {
        //TODO add other rules
        try {
            ArrayList<String> list = new ArrayList<String>(Arrays.asList("arr","acr","alr","aor","tcr","tor","eor"));
            JSONArray array = new JSONArray();
            for(int i = 0; i < list.size(); i++){
                JSONObject rules = repoDatabaseFacade.getRules(object, list.get(i));
                JSONArray array1 = rules.getJSONArray("rules");
                for(int j = 0; j < array1.length(); j++){
                    array.put(array1.get(j));
                }
            }
            JSONObject output = new JSONObject();
            output.put("rules", array);
            return Response.ok(output.toString(), MediaType.APPLICATION_JSON).build();
        }catch (Exception e){
            e.printStackTrace();
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }

    }
}
