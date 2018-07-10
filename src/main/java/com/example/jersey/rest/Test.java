package com.example.jersey.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.example.jersey.database.TargetDatabase;


@Path("/test")
public class Test {

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getString(){
        TargetDatabase database = new TargetDatabase();
        database.connect();

        database.disconnect();

        return "test";
    }

}
