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

@Path("/test2")
public class TemporaryRest {


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String test() {
        JSONObject obj = new JSONObject();
        JSONArray list = new JSONArray();
           list.put("hello");
           list.put("world");
        obj.put("messages", list);
        System.out.println(obj);
        String s = obj.toString();
        return s;
    }
}
