package com.example.jersey.resources.attributeResources;

import com.example.jersey.resources.ResourceFacade;
import com.example.jersey.resources.ResourceInterface;
import org.json.JSONObject;

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/businessRule/aor")
public class AttributeOtherResource implements ResourceInterface {
    @Override
    public Response get(String x) {
        ResourceFacade facade = new ResourceFacade();
        return facade.getAttributeOtherRule(new JSONObject(x));
    }

    @Override
    public Response getAll(String x) {
        ResourceFacade facade = new ResourceFacade();
        return facade.getAllAttributeOtherRules(new JSONObject(x));
    }

    @Override
    public Response define(String x) {
        ResourceFacade facade = new ResourceFacade();
        return facade.defineAttributeOtherRule(new JSONObject(x));
    }

    @Override
    public Response alter(String x) {
        ResourceFacade facade = new ResourceFacade();
        return facade.alterAttributeOtherRule(new JSONObject(x));
    }

    @Override
    public Response delete(String x) {
        ResourceFacade facade = new ResourceFacade();
        return facade.deleteBusinessRule(new JSONObject(x));
    }
}
