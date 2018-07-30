package com.example.jersey.resources;

import com.example.jersey.database.DatabaseFacade;
import com.example.jersey.domainTest.DomainFacade;
import org.json.JSONObject;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

public class ResourceFacade {

    DomainFacade domainFacade = new DomainFacade();
    DatabaseFacade databaseFacade = new DatabaseFacade();

    public Response defineAttributeRangeRule(JSONObject object){
        try{
            databaseFacade.defineAttributeRangeRule(domainFacade.defineAttributeRangeRule(object));
        }catch (Exception e){
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
        return Response.ok("{'do':5}", MediaType.APPLICATION_JSON).build();
    }

    public Response getAttributeRangeRule(JSONObject object){
        JSONObject object1 = null;
        try{
            object1 = databaseFacade.getAttributeRangeRule(object);
        }catch (Exception e){
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
        return Response.ok(object1, MediaType.APPLICATION_JSON).build();
    }

    public Response alterAttributeRangeRule(JSONObject object){
        try{
            databaseFacade.alterAttributeRangeRule(object);
        }catch (Exception e){
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
        return Response.ok("{'do':5}", MediaType.APPLICATION_JSON).build();
    }

    public Response deleteAttributeRangeRule(JSONObject object){
        try {
            databaseFacade.deleteAttributeRangeRule(object);
        }catch (Exception e){
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
        return Response.ok("{'do':5}", MediaType.APPLICATION_JSON).build();
    }

    public Response defineAttributeCompareRule(JSONObject object){
        try{
            databaseFacade.defineAttributeCompareRule(domainFacade.defineAttributeCompareRule(object));
        }catch (Exception e){
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
        return Response.ok("{'do':5}", MediaType.APPLICATION_JSON).build();
    }

    public Response alterAttributeCompareRule(JSONObject object){
        try{
            databaseFacade.alterAttributeCompareRule(object);
        }catch (Exception e){
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
        return Response.ok("{'do':5}", MediaType.APPLICATION_JSON).build();
    }

    public Response deleteAttributeCompareRule(JSONObject object){
        try {
            databaseFacade.deleteAttributeCompareRule(object);
        }catch (Exception e){
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
        return Response.ok("{'do':5}", MediaType.APPLICATION_JSON).build();
    }
}
