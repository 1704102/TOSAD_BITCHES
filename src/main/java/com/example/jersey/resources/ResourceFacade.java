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

<<<<<<< HEAD
    //<editor-fold desc="AttributeRangeRule">

    public Response defineAttributeRangeRule(JSONObject object){
        try{
            repoDatabaseFacade.defineAttributeRangeRule(domainFacade.defineAttributeRangeRule(object));
        }catch (Exception e){
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
        return Response.ok("{'do':5}", MediaType.APPLICATION_JSON).build();
    }

    public Response getAttributeRangeRule(JSONObject object){
        JSONObject object1 = null;
        try{
            object1 = repoDatabaseFacade.getAttributeRangeRule(object);
        }catch (Exception e){
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
        return Response.ok(object1, MediaType.APPLICATION_JSON).build();
    }

    public Response alterAttributeRangeRule(JSONObject object){
        try{
            repoDatabaseFacade.alterAttributeRangeRule(object);
        }catch (Exception e){
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
        return Response.ok("{'do':5}", MediaType.APPLICATION_JSON).build();
    }

    public Response deleteAttributeRangeRule(JSONObject object){
        try {
            repoDatabaseFacade.deleteAttributeRangeRule(object);
        }catch (Exception e){
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
        return Response.ok("{'do':5}", MediaType.APPLICATION_JSON).build();
    }

    // </editor-fold>
    //<editor-fold desc="AttributeCompareRule">

    public Response defineAttributeCompareRule(JSONObject object){
        try{
            repoDatabaseFacade.defineAttributeCompareRule(domainFacade.defineAttributeCompareRule(object));
        }catch (Exception e){
=======
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
>>>>>>> origin/martijndev
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
    }

<<<<<<< HEAD
    public Response getAttributeCompareRule(JSONObject object){
        try{
            //repoDatabaseFacade.get(domainFacade.defineAttributeCompareRule(object));
        }catch (Exception e){
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
        return Response.ok("{'do':5}", MediaType.APPLICATION_JSON).build();
    }

    public Response alterAttributeCompareRule(JSONObject object){
        try{
            repoDatabaseFacade.alterAttributeCompareRule(object);
        }catch (Exception e){
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
        return Response.ok("{'do':5}", MediaType.APPLICATION_JSON).build();
    }

    public Response deleteAttributeCompareRule(JSONObject object){
        try {
            repoDatabaseFacade.deleteAttributeCompareRule(object);
        }catch (Exception e){
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
        return Response.ok("{'do':5}", MediaType.APPLICATION_JSON).build();
    }

   //</editor-fold>
    //<editor-fold desc="User">
    public Response login(JSONObject object){
        try {
            repoDatabaseFacade.login(object);
        }catch (Exception e){
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
        return Response.ok("{'do':5}", MediaType.APPLICATION_JSON).build();
    }

    public Response register(JSONObject object) {
        try {
            repoDatabaseFacade.register(object);
        }catch (Exception e){
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
        return Response.ok("{'do':5}", MediaType.APPLICATION_JSON).build();
    }

    public Response addDatabase(JSONObject object) {
        try {
            repoDatabaseFacade.addDatabase(object);
        }catch (Exception e){
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
        return Response.ok("{'do':5}", MediaType.APPLICATION_JSON).build();
    }

    //</editor-fold>
    //<editor-fold desc="Target">
    public Response getTargetTables(JSONObject object){
        try{
            repoDatabaseFacade.defineAttributeCompareRule(domainFacade.defineAttributeCompareRule(object));
        }catch (Exception e){
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
        return Response.ok("{'do':5}", MediaType.APPLICATION_JSON).build();
    }
    public Response GetTargetColumns(JSONObject object){
        try{
            repoDatabaseFacade.defineAttributeCompareRule(domainFacade.defineAttributeCompareRule(object));
        }catch (Exception e){
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
        return Response.ok("{'do':5}", MediaType.APPLICATION_JSON).build();
    }
    public Response getTargetForeignKeys(JSONObject object){
        try{
            repoDatabaseFacade.defineAttributeCompareRule(domainFacade.defineAttributeCompareRule(object));
        }catch (Exception e){
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
        return Response.ok("{'do':5}", MediaType.APPLICATION_JSON).build();
    }

    //</editor-fold>
=======
    public Response updateRule(JSONObject object, String type){
        try {
            if (type.equals("iecr")) object.put("foreignkey", domainFacade.getForeignKey(object));
            repoDatabaseFacade.updateRule(object, type);
            if (object.getString("status").equals("activated") || object.getString("status").equals("deactivated")){
                targetDatabaseFacade.Generate(repoDatabaseFacade.getRule(object, type));
            }
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
            repoDatabaseFacade.updateRule(object, object.getString("type"));
        }catch (Exception e){
            e.printStackTrace();
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
        return Response.ok("{\"message\":\"rule generated\"}", MediaType.APPLICATION_JSON).build();
    }

    public Response deleteBusinessRule(JSONObject object){
        try {
            if (!object.getString("status").equals("new")){
                targetDatabaseFacade.delete(object);
            }

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
            ArrayList<String> list = new ArrayList<String>(Arrays.asList("arr","acr","alr","or","tcr", "iecr"));
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
>>>>>>> origin/martijndev
}
