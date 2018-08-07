package com.example.jersey.resources;

import com.example.jersey.database.Target.TargetDatabase;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/target")
public class TargetResource {

    @Path("/keys")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public void get(){
        TargetDatabase database = new TargetDatabase();
        database.getForeignKeys();
    }
}
