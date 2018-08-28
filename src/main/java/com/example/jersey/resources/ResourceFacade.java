package com.example.jersey.resources;

import com.example.jersey.database.repository.RepoDatabaseFacade;
import com.example.jersey.database.Target.TargetDatabase;
import com.example.jersey.domainTest.DomainFacade;
import org.json.JSONObject;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.concurrent.ExecutionException;

public class ResourceFacade {

    DomainFacade domainFacade = new DomainFacade();
    RepoDatabaseFacade repoDatabaseFacade = new RepoDatabaseFacade();

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
            repoDatabaseFacade.updateRule(object, type);
            return Response.ok("{\"response\":\" rule updated in database \"}", MediaType.APPLICATION_JSON).build();
        }catch (Exception e){
            e.printStackTrace();
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
    }

    public void generate(JSONObject object) {
        TargetDatabase database = new TargetDatabase();
        try {
            database.generateBusinessRule(object);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Response deleteBusinessRule(JSONObject object){
        try {
            //database.deleteConstraint(object);
            repoDatabaseFacade.deleteRule(object);
        }catch (Exception e){
            e.printStackTrace();
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
        return Response.ok("{\"message\":\"rule deleted\"}", MediaType.APPLICATION_JSON).build();
    }

    public Response activateRule(JSONObject object){
        try {
            new TargetDatabase().activateConstraint(object);
            repoDatabaseFacade.activate(object);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Response.ok("{\"message\":\"rule activated\"}", MediaType.APPLICATION_JSON).build();
    }

    public Response deactivateRule(JSONObject object){
        try {
            new TargetDatabase().deactivateConstraint(object);
            repoDatabaseFacade.deactivate(object);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Response.ok("{\"message\":\"rule deactivated\"}", MediaType.APPLICATION_JSON).build();
    }
}
