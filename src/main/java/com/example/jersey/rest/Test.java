package com.example.jersey.rest;

import com.example.jersey.Generator.BusinessRuleGenerator;
import com.example.jersey.database.TargetDatabase;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Path("/test")
public class Test {

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getString(){
        BusinessRuleGenerator generator = new BusinessRuleGenerator();
        generator.generateBusinessRule(null);

        return "test";
    }

}
