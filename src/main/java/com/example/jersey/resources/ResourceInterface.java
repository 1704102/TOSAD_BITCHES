package com.example.jersey.resources;

import org.json.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public interface ResourceInterface {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(String x);

    @Path("/all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(String x);

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response define(String x);

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response alter(String x);

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(String x);


}
