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

//    public Response defineAttributeCompareRule(JSONObject object){
//        try{
//            ArrayList<String> query = domainFacade.defineAttributeCompareRule(object);
//            databaseFacade.defineBusinessRuleRule(query);
//        }catch (Exception e){
//            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
//        }
//        return Response.ok("{'do':5}", MediaType.APPLICATION_JSON).build();
//    }
}
