package com.example.jersey.resources.attributeResources;

import com.example.jersey.resources.ResourceFacade;
import com.example.jersey.resources.ResourceInterface;
import org.json.JSONObject;

import javax.annotation.Resource;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/businessRule/acr")
public class AttributeCompareResource implements ResourceInterface {
    @Override
    public Response get(String x) {
        ResourceFacade facade = new ResourceFacade();
        return facade.getAttributeCompareRule(new JSONObject(x));
    }

    @Override
    public Response getAll(String x) {
        ResourceFacade facade = new ResourceFacade();
        return facade.getAllAttributeCompareRules(new JSONObject(x));
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
        return facade.deleteBusinessRule(new JSONObject(x));
    }

}