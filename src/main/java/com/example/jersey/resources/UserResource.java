package com.example.jersey.resources;
import org.json.JSONObject;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/user")
public class UserResource {

    @Path("/login")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(String x){
        ResourceFacade facade = new ResourceFacade();
        return facade.login(new JSONObject(x));
    }

    @Path("/register")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response resgister(String x){
        ResourceFacade facade = new ResourceFacade();
        return facade.register(new JSONObject(x));
    }

    @Path("/database")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response addDatabase(String x){
        ResourceFacade facade = new ResourceFacade();
        return facade.addDatabase(new JSONObject(x));
    }
}
