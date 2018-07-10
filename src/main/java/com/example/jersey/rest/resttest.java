package com.example.jersey.rest;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;

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
@Path("path")
public class resttest {
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String producecode() {
        String html="hello world";
        return html;
    }
}
