package com.example.jersey.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Path("/test")
public class Test {

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getString(){

        return "test";
    }

}
