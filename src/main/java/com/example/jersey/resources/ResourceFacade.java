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
            ArrayList<String> query = domainFacade.defineAttributeRangeRule(object);
            databaseFacade.defineAttributeRangeRule(query);
        }catch (Exception e){
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
        return Response.ok("{'do':5}", MediaType.APPLICATION_JSON).build();
    }
}
