package com.example.jersey.resources;

import com.example.jersey.database.Target.GenerateDatabase;
import org.json.JSONObject;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/target")
public class TargetResource {

    @Path("/columns")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response getColumns(String x){
        return new ResourceFacade().getColumns(new JSONObject(x));
    }

    @Path("/tables")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTables(String x){
        return new ResourceFacade().getTables(new JSONObject(x));
    }
}
