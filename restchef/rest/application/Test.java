package restchef.rest.application;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import restchef.logic.LogicContainer;

@Path("user")
public class Test {

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{name}")
	public String createChef(@PathParam("name") String name) {
		LogicContainer.getLogic().getList().insertTail(name);
		return "{\"status\":\"" + name + " aded\"}" ;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getChefList() {
		return "{\"chefs\":" + LogicContainer.getLogic().encodeList() + "}" ;
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{name}")
	public String deleteChef(@PathParam("name") String name) {
		return "{\"" + name + " deleted\":" + LogicContainer.getLogic().deleteChef(name) + "}" ;
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{name}")
	public String sayHelloJSON(@PathParam("name") String name) {
		return "{\"hola chef \":\"" + name + "\"}" ;
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("{name}")
	public String sayHelloText(@PathParam("name") String name) {
		return "hola chef " + name ;
	}

	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("{name}")
	public String sayHelloXML(@PathParam("name") String name) {
		return "<?xml version='1.0'?>" +
				"<hello>hola chef " + name +
				"</hello>";
	}

}
