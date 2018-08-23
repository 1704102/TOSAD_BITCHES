package com.example.jersey.resources.attributeResources;

import com.example.jersey.resources.ResourceFacade;
import com.example.jersey.resources.ResourceInterface;
import org.json.JSONObject;

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
@Path("/businessRule/alr")
public class AttributeListResource implements ResourceInterface {
    @Override
    public Response get(String x) {
        ResourceFacade facade = new ResourceFacade();
        return facade.getAttributeListRule(new JSONObject(x));
    }

    @Override
    public Response getAll(String x) {
        ResourceFacade facade = new ResourceFacade();
        return facade.getAllAttributeListRules(new JSONObject(x));
    }

    @Override
    public Response define(String x) {
        ResourceFacade facade = new ResourceFacade();
        return facade.defineAttributeListRule(new JSONObject(x));
    }

    @Override
    public Response alter(String x) {
        ResourceFacade facade = new ResourceFacade();
        return facade.alterAttributeListRule(new JSONObject(x));
    }

    @Override
    public Response delete(String x) {
        ResourceFacade facade = new ResourceFacade();
        return facade.deleteBusinessRule(new JSONObject(x));
    }
}
