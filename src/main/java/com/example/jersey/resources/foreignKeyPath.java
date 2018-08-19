package com.example.jersey.resources;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.example.jersey.database.RepoDatabaseFacade;
import com.example.jersey.database.Target.ForeignkeyDao;
import com.example.jersey.domainTest.DomainFacade;

import java.util.ArrayList;

@Path("/route")
public class foreignKeyPath {

    @GET
    @Produces(MediaType.TEXT_XML)
    public String excecute(){
        DomainFacade d = new DomainFacade();
        d.interEntityRule();

        return "<word>hello world</word>";

    }
}
