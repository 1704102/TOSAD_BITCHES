package com.example.jersey.resources;

import org.json.JSONObject;

import javax.annotation.Resource;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/businessRule/acr")
public class AttributeCompareResource implements ResourceInterface{
    @Override
    public Response get(String x) {
        return null;
    }

    @Override
    public Response getAll(String x) {
        return null;
    }

    @Override
    public Response define(String x) {
        ResourceFacade facade = new ResourceFacade();
        return facade.defineAttributeCompareRule(new JSONObject(x));
    }

    @Override
    public Response alter(String x) {
        ResourceFacade facade = new ResourceFacade();
        return facade.alterAttributeCompareRule(new JSONObject(x));
    }

    @Override
    public Response delete(String x) {
        ResourceFacade facade = new ResourceFacade();
        return facade.deleteAttributeCompareRule(new JSONObject(x));
    }

}