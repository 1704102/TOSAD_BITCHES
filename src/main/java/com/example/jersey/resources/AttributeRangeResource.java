package com.example.jersey.resources;

import com.example.jersey.domainTest.DomainFacade;
import com.sun.jersey.api.core.ParentRef;
import org.json.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/businessRule/arr")
public class AttributeRangeResource {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response getString(String x){
        ResourceFacade facade = new ResourceFacade();
        return facade.defineAttributeRangeRule(new JSONObject(x));
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response alter(String x){
        ResourceFacade facade = new ResourceFacade();
        return facade.alterAttributeRangeRule(new JSONObject(x));
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(String x){
        ResourceFacade facade = new ResourceFacade();
        return facade.deleteAttributeRangeRule(new JSONObject(x));
    }
}
