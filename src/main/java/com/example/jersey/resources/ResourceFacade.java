package com.example.jersey.resources;

import com.example.jersey.database.RepoDatabaseFacade;
import com.example.jersey.database.Target.TargetDatabase;
import com.example.jersey.domainTest.DomainFacade;
import org.json.JSONObject;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class ResourceFacade {

    DomainFacade domainFacade = new DomainFacade();
    RepoDatabaseFacade repoDatabaseFacade = new RepoDatabaseFacade();

    //<editor-fold desc="AttributeRangeRule">
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
    }

    // </editor-fold>
    //<editor-fold desc="AttributeCompareRule">

    public Response defineAttributeCompareRule(JSONObject object) {
        try {
            repoDatabaseFacade.defineAttributeCompareRule(domainFacade.defineAttributeCompareRule(object));
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
        return Response.ok("{'do':5}", MediaType.APPLICATION_JSON).build();
    }

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
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
        return Response.ok("{'do':5}", MediaType.APPLICATION_JSON).build();
    }

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
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
        return Response.ok("{'do':5}", MediaType.APPLICATION_JSON).build();
    }

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
    //<editor-fold desc="TupleOtherRule">

    public Response getAllTupleOtherRules(JSONObject object) {
        try {
            return Response.ok(repoDatabaseFacade.getAllTupleOtherRules(object).toString(), MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
    }

    public Response defineTupleOtherRule(JSONObject object) {
        try {
            repoDatabaseFacade.defineTupleOtherRule(domainFacade.defineTupleOtherRule(object));
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
        return Response.ok("{\"response\":\"complete\"}", MediaType.APPLICATION_JSON).build();
    }

    public Response getTupleOtherRule(JSONObject object) {
        JSONObject object1 = null;
        try {
            object1 = repoDatabaseFacade.getTupleOtherRule(object);
        } catch (Exception e) {
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
        return Response.ok(object1.toString(), MediaType.APPLICATION_JSON).build();
    }

    public Response alterTupleOtherRule(JSONObject object) {
        try {
            repoDatabaseFacade.alterTupleOtherRule(object);
        } catch (Exception e) {
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
        return Response.ok("{\"response\":\"complete\"}", MediaType.APPLICATION_JSON).build();
    }

    public Response deleteTupleOtherRule(JSONObject object) {
        try {
            repoDatabaseFacade.deleteTupleOtherRule(object);
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
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
        return Response.ok("{'do':5}", MediaType.APPLICATION_JSON).build();
    }

    public Response register(JSONObject object) {
        try {
            repoDatabaseFacade.register(object);
        } catch (Exception e) {
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
        return Response.ok("{'do':5}", MediaType.APPLICATION_JSON).build();
    }

    public Response addDatabase(JSONObject object) {
        try {
            repoDatabaseFacade.addDatabase(object);
        } catch (Exception e) {
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
        return Response.ok("{'do':5}", MediaType.APPLICATION_JSON).build();
    }

    //</editor-fold>
    //<editor-fold desc="Target">
    public Response getTargetTables(JSONObject object) {
        try {
            repoDatabaseFacade.defineAttributeCompareRule(domainFacade.defineAttributeCompareRule(object));
        } catch (Exception e) {
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
        return Response.ok("{'do':5}", MediaType.APPLICATION_JSON).build();
    }

    public Response GetTargetColumns(JSONObject object) {
        try {
            repoDatabaseFacade.defineAttributeCompareRule(domainFacade.defineAttributeCompareRule(object));
        } catch (Exception e) {
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
        return Response.ok("{'do':5}", MediaType.APPLICATION_JSON).build();
    }

    public Response getTargetForeignKeys(JSONObject object) {
        try {
            repoDatabaseFacade.defineAttributeCompareRule(domainFacade.defineAttributeCompareRule(object));
        } catch (Exception e) {
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
        return Response.ok("{'do':5}", MediaType.APPLICATION_JSON).build();
    }

    public void generate(JSONObject object) {
        TargetDatabase database = new TargetDatabase();
        try {
            database.generateBusinessRule(object);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void delete(JSONObject object) {
        TargetDatabase database = new TargetDatabase();
        try {
            database.deleteConstraint(object);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    //</editor-fold>
}
