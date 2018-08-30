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

    private final String TYPE = "acr";

    @Override
    public Response get(String x) {
        ResourceFacade facade = new ResourceFacade();
        return facade.getRule(new JSONObject(x), TYPE);
    }

    @Override
    public Response getAll(String x) {
<<<<<<< HEAD:src/main/java/com/example/jersey/resources/AttributeCompareResource.java
<<<<<<< HEAD
        return null;
=======
        ResourceFacade facade = new ResourceFacade();
        return facade.getAllAttributeCompareRules(new JSONObject(x));
>>>>>>> origin/martijndev
=======
<<<<<<< HEAD:src/main/java/com/example/jersey/resources/AttributeCompareResource.java
        return null;
=======
        ResourceFacade facade = new ResourceFacade();
        return facade.getRules(new JSONObject(x), TYPE);
>>>>>>> origin/martijndev:src/main/java/com/example/jersey/resources/attributeResources/AttributeCompareResource.java
>>>>>>> development:src/main/java/com/example/jersey/resources/attributeResources/AttributeCompareResource.java
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