package com.example.jersey.rest;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

import com.example.jersey.dao.BusinessRuleComponentDao;
import com.example.jersey.dao.BusinessRuleCompositeDao;
import com.example.jersey.dao.impl.BusinessRuleComponentImplements;
import com.example.jersey.dao.impl.BusinessRuleCompositeImplements;
import com.example.jersey.domain.AttributeRule;
import com.example.jersey.domain.BusinessRuleComponent;
import com.example.jersey.domain.BusinessRuleComposite;
import com.example.jersey.domain.CompareRule;
import com.example.jersey.domain.Operator;

@Path("composites")
public class BusinessRuleRestService {
	
	private static final BusinessRuleComponentDao brcomponentDao = new BusinessRuleComponentImplements();
	private static final BusinessRuleCompositeDao brcompositeDao = new BusinessRuleCompositeImplements();
	// missing functional requirements:
	// - matching the right response for other components
	
	private JSONObject makeBrcJSONObject(BusinessRuleComponent brc, String operType) {
		JSONObject jobj = new JSONObject();
		System.out.println("BusinessRuleRestService JsonBuilder: " + brc.getComponentName());
		if(brc != null) {
			System.out.println("BusinessRuleRestService JsonBuilder: " + brc.getComponentName());
		if (brc.getComponentName() != null ) {
			// Check for duplicates
			switch(operType) {
				case "validate" : 
					if(brcomponentDao.exist(brc)) {
						jobj.accumulate("warning", "component already exist");
					};
					break;
				case "create" :
					jobj.accumulate("name", brc.getComponentName());
					break;
				default :
					jobj.accumulate("error", "operation is undefined");
					break;
			}
			
		} else {
		jobj.accumulate("error", "businessrule component name is Empty!");
		}
		
	} else {
		jobj.accumulate("error", "businessrule component doesn't exist!");
	}
		return jobj;
	}
		
	// missing functional requirements
	// - process parameters from multiple rule types
	@GET
	@Path("/attribute/component/{name}/check/{parameter}")
	@Produces(MediaType.APPLICATION_JSON)
	public String exist(
			@PathParam("name") String name,
			@PathParam("parameter") String parameter) {
		// delegates matching to persistComponent
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
			@FormParam("comparison") String comparison
			) throws SQLException {
		
		if( buildAttributeCompareRule(attributeValue,comparison,operator)) {
			return Response.status(Response.Status.OK).build();
		} else {
			return Response.status(Response.Status.NOT_MODIFIED).build();
		}
		
	}
	
	// JanHub: Request for comments
	// 1. build the attribute compare rule
	private boolean buildAttributeCompareRule(String attributeValue,String comparison, String operator) {
		// 1.1 check if similar entities already exist
				List<BusinessRuleComponent> components = new ArrayList<BusinessRuleComponent>();
		components.add(new AttributeRule(attributeValue));
		components.add(new CompareRule(comparison));
		components.add(new Operator(operator));
		
		for (BusinessRuleComponent component: components) {
			if( brcomponentDao.exist(component) ) {
				// missing functionality: reuse the matching component in the database
				return false;
			}
		}
		String brCode = "ACMP"; // Dat mag lekker iemand anders gaan doen
		
		BusinessRuleComposite brc = new BusinessRuleComposite(brCode);
		if( brcompositeDao.saveComposite(brc)) {
			return true;
		} else {
			return false;
		}
	}
	
}
