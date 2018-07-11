package com.example.jersey.servlet;


import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONObject;

import com.example.jersey.Visitor.DefineBusinessRuleService;
import com.example.jersey.Visitor.ServiceProvider;
import com.example.jersey.domain.AttributeRule;
import com.example.jersey.domain.BusinessRuleComponent;
import com.example.jersey.domain.BusinessRuleComposite;
import com.example.jersey.domain.CompareRule;
import com.example.jersey.domain.Operator;

@Path("composites")
public class BusinessRuleResource {
	private static final DefineBusinessRuleService definerservice = ServiceProvider.getDefineBusinessRuleService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllRules() {
		JSONArray jab = new JSONArray();
		List<BusinessRuleComposite> composites = new ArrayList<BusinessRuleComposite>();
		composites.addAll(definerservice.getAllComposites());
		jab.put(composites);
		System.out.println("com.example.jersey.servlet Resource getAll: " + composites);
		//TODO: mapmappableexception en nullpointerexception oplossen
		for(BusinessRuleComposite composite : composites) {
			JSONArray jab2 = new JSONArray();
			for(BusinessRuleComponent component : composite.getChildren()) {
				// TODO: Missing functionality
				// get the inferred type of each component dynamically
				JSONObject job = new JSONObject();
				System.out.println("com.example.jersey.servlet Resource getAll: " + component.getComponentName());
				System.out.println("com.example.jersey.servlet Resource getAll: " + component.toString());
				job.accumulate("attribute", component.getComponentName());
				job.accumulate("data", component.toString());
				jab2.put(job);
				System.out.println(job.toString());
			}
			jab.put(jab2);
		}
		
		return jab.toString();
	}

	
	// to keep it addressable for the demo, I'll just call the attribute range rule
	@POST
	@Path("defineByComponents")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response defineNewBusinessRule(
		String x
		) {
		JSONObject job = new JSONObject(x);
		System.out.println("x waarde " + x);
		System.out.println("job waarde " + job);
		
		List<BusinessRuleComponent> components = new ArrayList<BusinessRuleComponent>();
			components.add(new AttributeRule(job.getString("attributeValue")));
			components.add(new CompareRule(job.getString("comparison")));
			components.add(new Operator(job.getString("operator")));
		
			System.out.println(components.get(0).toString());
			System.out.println(components.get(1).toString());
			System.out.println(components.get(2).toString());
		BusinessRuleComposite newComposite = definerservice.getCompositeByComponents(components);
		if(definerservice.newBusinessRule(newComposite)) {
			return Response.status(Response.Status.OK).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build(); // derp
		}
	}
	
	@GET
	@Path("hello")
	@Produces(MediaType.APPLICATION_JSON)
	public String hello() {
		JSONObject job = new JSONObject();
		job.accumulate("message", "hello");
		return job.toString();
	}
	
	@POST
	@Path("thankyou")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response newitem(@FormParam("name") String name)
		throws IllegalStateException {
		BusinessRuleComposite acmp = new BusinessRuleComposite("ACMP");
		System.out.println(acmp.getTerminalExpression());
		acmp.add(new AttributeRule(name));
		
		//List<BusinessRuleComponent> components = acmp.getChildren();
//		boolean equals = components.isEmpty();
		// System.out.println(equals);
		
		System.out.println("null? \n" + acmp.getChildren().get(0).toString());
		return Response.status(Response.Status.NO_CONTENT).build();
		
	}
//	
//	@GET
//	@Path("{id}")
//	@Produces(MediaType.APPLICATION_JSON)
//	public String find(@PathParam("id") int id) {
//		JSONObject job = new JSONObject();
//		job.accumulate("attributevalue", )
//	}
}
