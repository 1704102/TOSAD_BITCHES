package com.example.jersey.resources;

import jdk.nashorn.internal.objects.annotations.Getter;
import org.json.JSONObject;

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
@Path("/businessRule/tcr")
public class TupleCompareResource implements ResourceInterface{
    @Override
    public Response get(String x) {
        ResourceFacade facade = new ResourceFacade();
        return facade.getTupleCompareRule(new JSONObject(x));
    }

    @Override
    public Response getAll(String x) {
        ResourceFacade facade = new ResourceFacade();
        return facade.getAllTupleCompareRules(new JSONObject(x));
    }

    @Override
    public Response define(String x) {
        ResourceFacade facade = new ResourceFacade();
        return facade.defineTupleCompareRule(new JSONObject(x));
    }

    @Override
    public Response alter(String x) {
        ResourceFacade facade = new ResourceFacade();
        return facade.alterTupleCompareRule(new JSONObject(x));
    }

    @Override
    public Response delete(String x) {
        ResourceFacade facade = new ResourceFacade();
        return facade.deleteTupleCompareRule(new JSONObject(x));
    }
}
