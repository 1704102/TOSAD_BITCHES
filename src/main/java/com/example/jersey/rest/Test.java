package com.example.jersey.rest;

import com.example.jersey.Generator.BusinessRuleGenearator;
import com.example.jersey.database.TargetDatabase;
import com.example.jersey.domain.AttributeRule;
import com.example.jersey.domain.BusinessRuleComponent;
import com.example.jersey.domain.CompareRule;
import com.example.jersey.domain.Operator;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;


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
