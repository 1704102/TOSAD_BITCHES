package com.example.jersey.resources.tupleResources;

import com.example.jersey.resources.ResourceFacade;
import com.example.jersey.resources.ResourceInterface;
import org.json.JSONObject;

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/businessRule/tor")
public class TupleOtherResource implements ResourceInterface {
    @Override
    public Response get(String x) {
        ResourceFacade facade = new ResourceFacade();
        return facade.getTupleOtherRule(new JSONObject(x));
    }

    @Override
    public Response getAll(String x) {
        ResourceFacade facade = new ResourceFacade();
        return facade.getAllTupleOtherRules(new JSONObject(x));
    }

    @Override
    public Response define(String x) {
        ResourceFacade facade = new ResourceFacade();
        return facade.defineTupleOtherRule(new JSONObject(x));
    }

    @Override
    public Response alter(String x) {
        ResourceFacade facade = new ResourceFacade();
        return facade.alterTupleOtherRule(new JSONObject(x));
    }

    @Override
    public Response delete(String x) {
        ResourceFacade facade = new ResourceFacade();
        return facade.deleteBusinessRule(new JSONObject(x));
    }
}
