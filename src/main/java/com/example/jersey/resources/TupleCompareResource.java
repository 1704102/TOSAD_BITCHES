package com.example.jersey.resources;

import jdk.nashorn.internal.objects.annotations.Getter;
import org.json.JSONObject;

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
@Path("/businessRule/tcr")
public class TupleCompareResource implements ResourceInterface{
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
        return facade.defineTupleCompareRule(new JSONObject(x));
    }

    @Override
    public Response alter(String x) {
        return null;
    }

    @Override
    public Response delete(String x) {
        return null;
    }
}
