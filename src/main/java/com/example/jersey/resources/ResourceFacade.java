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
<<<<<<< HEAD

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
=======
    public Response getAllAttributeRangeRules(JSONObject object) {
        try {
            return Response.ok(repoDatabaseFacade.getAllAttributeRangeRules(object).toString(), MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
    }

    public Response defineAttributeRangeRule(JSONObject object) {
        try {
            repoDatabaseFacade.defineAttributeRangeRule(domainFacade.defineAttributeRangeRule(object));
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
        return Response.ok("{\"response\":\"complete\"}", MediaType.APPLICATION_JSON).build();
    }

    public Response getAttributeRangeRule(JSONObject object) {
        JSONObject object1 = null;
        try {
            object1 = repoDatabaseFacade.getAttributeRangeRule(object);
        } catch (Exception e) {
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
        return Response.ok(object1.toString(), MediaType.APPLICATION_JSON).build();
    }

    public Response alterAttributeRangeRule(JSONObject object) {
        try {
            repoDatabaseFacade.alterAttributeRangeRule(object);
        } catch (Exception e) {
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
        return Response.ok("{\"response\":\"complete\"}", MediaType.APPLICATION_JSON).build();
    }

    public Response deleteAttributeRangeRule(JSONObject object) {
        try {
            repoDatabaseFacade.deleteAttributeRangeRule(object);
        } catch (Exception e) {
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
        return Response.ok("{\"response\":\"complete\"}", MediaType.APPLICATION_JSON).build();
>>>>>>> origin/martijndev
    }

    // </editor-fold>
    //<editor-fold desc="AttributeCompareRule">

<<<<<<< HEAD
    public Response defineAttributeCompareRule(JSONObject object){
        try{
            repoDatabaseFacade.defineAttributeCompareRule(domainFacade.defineAttributeCompareRule(object));
        }catch (Exception e){
=======
    public Response defineAttributeCompareRule(JSONObject object) {
        try {
            repoDatabaseFacade.defineAttributeCompareRule(domainFacade.defineAttributeCompareRule(object));
        } catch (Exception e) {
            e.printStackTrace();
>>>>>>> origin/martijndev
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
        return Response.ok("{'do':5}", MediaType.APPLICATION_JSON).build();
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
=======
    public Response getAllAttributeCompareRules(JSONObject object) {
        try {
            return Response.ok(repoDatabaseFacade.getAllAttributeCompareRules(object).toString(), MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
    }

    public Response getAttributeCompareRule(JSONObject object) {
        try {
            return Response.ok(repoDatabaseFacade.getAttributeCompareRule(object).toString(), MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }

    }

    public Response alterAttributeCompareRule(JSONObject object) {
        try {
            repoDatabaseFacade.alterAttributeCompareRule(object);
        } catch (Exception e) {
            e.printStackTrace();
>>>>>>> origin/martijndev
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
        return Response.ok("{'do':5}", MediaType.APPLICATION_JSON).build();
    }

<<<<<<< HEAD
    public Response deleteAttributeCompareRule(JSONObject object){
        try {
            repoDatabaseFacade.deleteAttributeCompareRule(object);
        }catch (Exception e){
=======
    public Response deleteAttributeCompareRule(JSONObject object) {
        try {
            repoDatabaseFacade.deleteAttributeCompareRule(object);
        } catch (Exception e) {
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
        return Response.ok("{'do':5}", MediaType.APPLICATION_JSON).build();
    }

    //</editor-fold>
    //<editor-fold desc="AttributeListRule">
    public Response defineAttributeListRule(JSONObject object) {
        try {
           repoDatabaseFacade.defineAttributeListRule(domainFacade.defineAttributeListRule(object));
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
        return Response.ok("{'do':5}", MediaType.APPLICATION_JSON).build();
    }

    public Response getAllAttributeListRules(JSONObject object) {
        try {
            return Response.ok(repoDatabaseFacade.getAllAttributeListRules(object).toString(), MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
    }

    public Response getAttributeListRule(JSONObject object) {
        JSONObject object1 = null;
        try {
            object1 = repoDatabaseFacade.getAttributeListRule(object);
        } catch (Exception e) {
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
        return Response.ok(object1.toString(), MediaType.APPLICATION_JSON).build();
    }

    public Response alterAttributeListRule(JSONObject object) {
        try {
            repoDatabaseFacade.alterAttributeListRule(object);
        } catch (Exception e) {
            e.printStackTrace();
>>>>>>> origin/martijndev
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
        return Response.ok("{'do':5}", MediaType.APPLICATION_JSON).build();
    }

<<<<<<< HEAD
   //</editor-fold>
    //<editor-fold desc="User">
    public Response login(JSONObject object){
        try {
            repoDatabaseFacade.login(object);
        }catch (Exception e){
=======
    public Response deleteAttributeListRule(JSONObject object) {
        try {
            repoDatabaseFacade.deleteAttributeListRule(object);
        } catch (Exception e) {
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
        return Response.ok("{'do':5}", MediaType.APPLICATION_JSON).build();
    }
    //</editor-fold>
    //<editor-fold desc="TupleCompareRule">
    public Response getAllTupleCompareRules(JSONObject object) {
        try {
            return Response.ok(repoDatabaseFacade.getAllTupleCompareRules(object).toString(), MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
    }

    public Response defineTupleCompareRule(JSONObject object) {
        try {
            repoDatabaseFacade.defineTupleCompareRule(domainFacade.defineTupleCompareRule(object));
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
        return Response.ok("{\"response\":\"complete\"}", MediaType.APPLICATION_JSON).build();
    }

    public Response getTupleCompareRule(JSONObject object) {
        JSONObject object1 = null;
        try {
            object1 = repoDatabaseFacade.getTupleCompareRule(object);
        } catch (Exception e) {
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
        return Response.ok(object1.toString(), MediaType.APPLICATION_JSON).build();
    }

    public Response alterTupleCompareRule(JSONObject object) {
        try {
            repoDatabaseFacade.alterTupleCompareRule(object);
        } catch (Exception e) {
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
        return Response.ok("{\"response\":\"complete\"}", MediaType.APPLICATION_JSON).build();
    }

    public Response deleteTupleCompareRule(JSONObject object) {
        try {
            repoDatabaseFacade.deleteTupleCompareRule(object);
        } catch (Exception e) {
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
        return Response.ok("{\"response\":\"complete\"}", MediaType.APPLICATION_JSON).build();
    }
    //</editor-fold>
    //<editor-fold desc="User">
    public Response login(JSONObject object) {
        try {
            repoDatabaseFacade.login(object);
        } catch (Exception e) {
>>>>>>> origin/martijndev
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
        return Response.ok("{'do':5}", MediaType.APPLICATION_JSON).build();
    }

    public Response register(JSONObject object) {
        try {
            repoDatabaseFacade.register(object);
<<<<<<< HEAD
        }catch (Exception e){
=======
        } catch (Exception e) {
>>>>>>> origin/martijndev
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
        return Response.ok("{'do':5}", MediaType.APPLICATION_JSON).build();
    }

    public Response addDatabase(JSONObject object) {
        try {
            repoDatabaseFacade.addDatabase(object);
<<<<<<< HEAD
        }catch (Exception e){
=======
        } catch (Exception e) {
>>>>>>> origin/martijndev
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
        return Response.ok("{'do':5}", MediaType.APPLICATION_JSON).build();
    }

    //</editor-fold>
    //<editor-fold desc="Target">
<<<<<<< HEAD
    public Response getTargetTables(JSONObject object){
        try{
            repoDatabaseFacade.defineAttributeCompareRule(domainFacade.defineAttributeCompareRule(object));
        }catch (Exception e){
=======
    public Response getTargetTables(JSONObject object) {
        try {
            repoDatabaseFacade.defineAttributeCompareRule(domainFacade.defineAttributeCompareRule(object));
        } catch (Exception e) {
>>>>>>> origin/martijndev
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
        return Response.ok("{'do':5}", MediaType.APPLICATION_JSON).build();
    }
<<<<<<< HEAD
    public Response GetTargetColumns(JSONObject object){
        try{
            repoDatabaseFacade.defineAttributeCompareRule(domainFacade.defineAttributeCompareRule(object));
        }catch (Exception e){
=======

    public Response GetTargetColumns(JSONObject object) {
        try {
            repoDatabaseFacade.defineAttributeCompareRule(domainFacade.defineAttributeCompareRule(object));
        } catch (Exception e) {
>>>>>>> origin/martijndev
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
        return Response.ok("{'do':5}", MediaType.APPLICATION_JSON).build();
    }
<<<<<<< HEAD
    public Response getTargetForeignKeys(JSONObject object){
        try{
            repoDatabaseFacade.defineAttributeCompareRule(domainFacade.defineAttributeCompareRule(object));
        }catch (Exception e){
=======

    public Response getTargetForeignKeys(JSONObject object) {
        try {
            repoDatabaseFacade.defineAttributeCompareRule(domainFacade.defineAttributeCompareRule(object));
        } catch (Exception e) {
>>>>>>> origin/martijndev
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
        return Response.ok("{'do':5}", MediaType.APPLICATION_JSON).build();
    }

<<<<<<< HEAD
=======



>>>>>>> origin/martijndev
    //</editor-fold>
}
