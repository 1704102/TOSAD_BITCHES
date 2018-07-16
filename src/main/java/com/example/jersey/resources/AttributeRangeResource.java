package com.example.jersey.resources;

import com.example.jersey.domainTest.DomainFacade;
import com.sun.jersey.api.core.ParentRef;
import org.json.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/businessRule/arr")
public class AttributeRangeResource {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response getString(String x){
        ResourceFacade facade = new ResourceFacade();
        return facade.defineAttributeRangeRule(new JSONObject(x));
    }

}
