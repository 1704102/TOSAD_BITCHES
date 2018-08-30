package com.example.jersey.resources.attributeResources;

import com.example.jersey.resources.ResourceFacade;
import com.example.jersey.resources.ResourceInterface;
import org.json.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/businessRule/arr")
public class AttributeRangeResource implements ResourceInterface {

    private final String TYPE = "arr";

    @Override
    public Response get(String x) {
        ResourceFacade facade = new ResourceFacade();
        return facade.getRule(new JSONObject(x), TYPE);
    }

    @Override
    public Response getAll(String x) {
<<<<<<< HEAD:src/main/java/com/example/jersey/resources/AttributeRangeResource.java
        return null;
=======
        ResourceFacade facade = new ResourceFacade();
        return facade.getRules(new JSONObject(x), TYPE);
>>>>>>> origin/martijndev:src/main/java/com/example/jersey/resources/attributeResources/AttributeRangeResource.java
    }

    @Override
    public Response define(String x) {
        ResourceFacade facade = new ResourceFacade();
        return facade.defineRule(new JSONObject(x), TYPE);
    }

    @Override
    public Response alter(String x) {
        ResourceFacade facade = new ResourceFacade();
        return facade.updateRule(new JSONObject(x), TYPE);
    }

    @Override
    public Response delete(String x) {
        ResourceFacade facade = new ResourceFacade();
        return facade.deleteBusinessRule(new JSONObject(x));
    }
}
