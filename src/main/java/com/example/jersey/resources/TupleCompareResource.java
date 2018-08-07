package com.example.jersey.resources;

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

@Path("tcr")
public class TupleCompareResource implements ResourceInterface {

	@Override
	public Response get(String x) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response getAll(String x) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response define(String x) {
		ResourceFacade facade = new ResourceFacade();
        return facade.defineTupleCompareRule(new JSONObject(x));
	}

	@Override
	public Response alter(String x) {
		 ResourceFacade facade = new ResourceFacade();
	        return facade.alterAttributeRangeRule(new JSONObject(x));
	}

	@Override
	public Response delete(String x) {
		 ResourceFacade facade = new ResourceFacade();
	        return facade.deleteAttributeRangeRule(new JSONObject(x));
	}
	
}
