package com.example.jersey.resources;

import com.example.jersey.database.RepoDatabaseFacade;
import com.example.jersey.domainTest.DomainFacade;
import org.json.JSONObject;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class ResourceFacade {

    DomainFacade domainFacade = new DomainFacade();
    RepoDatabaseFacade repoDatabaseFacade = new RepoDatabaseFacade();

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
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
        return Response.ok("{'do':5}", MediaType.APPLICATION_JSON).build();
    }

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

    
    public Response defineTupleCompareRule(JSONObject object){
        try{
            repoDatabaseFacade.defineAttributeCompareRule(domainFacade.defineAttributeCompareRule(object));

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

}
