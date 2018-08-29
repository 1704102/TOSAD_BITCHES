package com.example.jersey.resources.entity;

import com.example.jersey.database.Target.TargetDatabase;
import com.example.jersey.domainTest.DomainFacade;
import com.example.jersey.resources.ResourceFacade;
import com.example.jersey.resources.ResourceInterface;
import org.jboss.shrinkwrap.api.Domain;
import org.json.JSONObject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
@Path("/businessRule/iecr")
public class EntityCompareResource implements ResourceInterface {

    private final String TYPE = "iecr";

    @Override
    public Response get(String x) {
        ResourceFacade facade = new ResourceFacade();
        return facade.getRule(new JSONObject(x), TYPE);
    }

    @Override
    public Response getAll(String x) {
        ResourceFacade facade = new ResourceFacade();
        return facade.getRules(new JSONObject(x), TYPE);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response test(){
        try {
            new DomainFacade().interEntityRuleFk("PERSONS", "PRODUCTS");
        }catch (Exception e){
            e.printStackTrace();
        }

        return Response.ok("{\"response\":\" rule added to test \"}", MediaType.APPLICATION_JSON).build();
    }

    @Override
    public Response define(String x) {
        ResourceFacade facade = new ResourceFacade();
        return facade.defineRule(new JSONObject(x), TYPE);
    }

    @Override
    public Response alter(String x) {
        ResourceFacade facade = new ResourceFacade();
        return facade.updateRule(new JSONObject(x), TYPE);
    }

    @Override
    public Response delete(String x) {
        ResourceFacade facade = new ResourceFacade();
        return facade.deleteBusinessRule(new JSONObject(x));
    }
}
