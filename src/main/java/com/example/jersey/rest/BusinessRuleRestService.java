package com.example.jersey.rest;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import com.example.jersey.dao.BusinessRuleCompositeDao;
import com.example.jersey.dao.impl.BusinessRuleCompositeImplements;
import com.example.jersey.domain.AttributeRule;
import com.example.jersey.domain.BusinessRuleComponent;
import com.example.jersey.domain.BusinessRuleComposite;

@Path("compositestest")
public class BusinessRuleRestService {
	
	private static final BusinessRuleCompositeDao proxy = new BusinessRuleCompositeImplements();
	
	//
	// missing functional requirements:
	// - matching the right response for other components
	// 13-7: altered to make the phases in the cycle smarter and more useful
	//
	
	private JSONObject makeBrcJSONObject(BusinessRuleComponent brc, String operType) {
		JSONObject jobj = new JSONObject();
		
		//
		// testing the input with system out
		//
		
		System.out.println("BusinessRuleRestService JsonBuilder: " + brc.getComponentName());
		
		jobj.accumulate("error", "businessrule component doesn't exist!");
		if(brc != null) {
			System.out.println("BusinessRuleRestService JsonBuilder: " + brc.getComponentName());
			if (brc.getComponentName() != null ) {
				
				//
				// Check for duplicates
				//
				
				switch(operType) {
					case "validate" : // for GET requests
						return jobj.accumulate("name", brc.getComponentName());
					case "create" : // for POST and PUT requests
						return jobj.accumulate("name", brc.getComponentName());
					default :
						return jobj.accumulate("error", "operation is undefined");
				}
			} 
			jobj.accumulate("error", "businessrule component name is Empty!"); 
		} 
		return jobj;
	}
	
	//
	// missing functional requirements
	// - process parameters from multiple rule types
	//
	
	@GET
	@Path("/attribute/component/{name}/check/{parameter}")
	@Produces(MediaType.APPLICATION_JSON)
	public String exist(
			@PathParam("name") String name,
			@PathParam("parameter") String parameter) {
		
		//
		// delegates matching to persistComponent
		//
		
		JSONObject jobj = new JSONObject();
		BusinessRuleComponent newComponent = new AttributeRule(name);
		jobj = makeBrcJSONObject(newComponent, "validate");
		return jobj.toString();
	}
	
	@POST
	@Path("attribute/compare")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response defineAttributeCompareRule(
			@FormParam("attributeValue") String attributeValue,
			@FormParam("operator") String operator,
			@FormParam("comparison") int comparison // is a string
			) throws SQLException {
		
		if( buildAttributeCompareRule(attributeValue,comparison,operator)) {
			return Response.status(Response.Status.OK).build();
		} else {
			return Response.status(Response.Status.NOT_MODIFIED).build();
		}
	}
	
	//
	// JanHub: Request for comments
	// 1. build the attribute compare rule
	//
	
	private boolean buildAttributeCompareRule(String attributeValue,int comparison, String operator) {
		
		//
		// 1.1 check if similar entities already exist
		//		
		
		BusinessRuleComposite brc = new BusinessRuleComposite("ACMP");
		if( proxy.saveComposite(brc)) {
			return true;
			
		} else {
			return false;
			
		}
	}
	
}
