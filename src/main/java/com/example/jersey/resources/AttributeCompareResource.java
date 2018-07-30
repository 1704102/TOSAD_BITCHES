package com.example.jersey.resources;

import org.json.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/businessRule/acr")
public class AttributeCompareResource {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response define(String x){
        ResourceFacade facade = new ResourceFacade();
        return facade.defineAttributeCompareRule(new JSONObject(x));
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response alter(String x){
        ResourceFacade facade = new ResourceFacade();
        return facade.alterAttributeCompareRule(new JSONObject(x));
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(String x){
        ResourceFacade facade = new ResourceFacade();
        return facade.defineAttributeCompareRule(new JSONObject(x));
    }

}