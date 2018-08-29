package com.example.jersey.resources.entity;

import com.example.jersey.resources.ResourceFacade;
import com.example.jersey.resources.ResourceInterface;

import javax.ws.rs.core.Response;

public class EntityCompareResource implements ResourceInterface {
    @Override
    public Response get(String x) {
        ResourceFacade facade = new ResourceFacade();
        return null;
    }

    @Override
    public Response getAll(String x) {
        return null;
    }

    @Override
    public Response define(String x) {
        return null;
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
