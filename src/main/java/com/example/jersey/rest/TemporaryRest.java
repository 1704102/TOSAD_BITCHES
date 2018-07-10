package com.example.jersey.rest;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.HTTP;

import javax.ws.rs.PathParam;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("/h")
public class TemporaryRest {


    @GET
    @Produces(MediaType.TEXT_HTML)
    public String test() {
        ArrayList<String> bob= new ArrayList();
        bob.add("bob");
        bob.add("bib");
        bob.add("bub");
        String s = "<select>";

        for(String q : bob){
            s =s+ "<option value="+q+">"+q +"</input>";
        }



        return s;
    }
}
