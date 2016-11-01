package restchef.rest.application;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONObject;

import restchef.json.JsonStatus;
import restchef.logic.Chef;
import restchef.logic.LogicContainer;

@Path("chef")
public class ChefApplication {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Chef createChef(Chef chef) {
		//System.out.println(chef.getName());
		//System.out.println(chef.getEmail());
		return new Chef("maria","puta");	
	}
	
	@GET
	@Path("{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject getChefInfo(@PathParam("name") String chefName) {
		return LogicContainer.getLogic().getChef(chefName);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject getChefList() {
		//json con la lista de los chefs
		return JsonStatus.encode("inactive");
	}
	
	@POST
	@Path("chat")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject postMessage(String jsonMessage) {
		return LogicContainer.getLogic().postMessage(jsonMessage);
	}
	
	/*
	@DELETE
	@Path("{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteChef(@PathParam("name") String chef) {
		//json indicando si se removio o no
		return null;
	}
	
	@POST
	@Path("menu")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String createDish() {
		//json con la informacion del platillo
		//json confirmando si se creo el platillo
		return null;
	}
	
	@DELETE
	@Path("menu/{dish}")
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteDish(@PathParam("dish") String dish) {
		//json confirmando si se elimino el platillo
		return null;		
	}
	
	@GET
	@Path("menu")
	@Produces(MediaType.APPLICATION_JSON)
	public String getDishList() {
		//json con la lista de los platillos
		return null;
	}
	
	@GET
	@Path("menu/{dish}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getDish(@PathParam("dish") String dish) {
		//retorna la informacion del platillo consultado
		return null;
	}
	
	
	@POST
	@Path("stock")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String createSupply() {
		//consume json con la informacion del suministo,, nombre categoria y cant
		//retorna el estado de la creacion del ingrediente
		return null;
	}
	
	@GET
	@Path("stock/{supply}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getSupply(@PathParam("supply") String supply) {
		//retorna la informacion del platillo consutado
		return null;
	}
	
	@DELETE
	@Path("stock/{supply}")
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteSupply(@PathParam("supply") String supply) {
		//retorna un json indicando el estado de la eliminacion del platillo
		return null;
	}
	
	@GET
	@Path("stock")
	@Produces(MediaType.APPLICATION_JSON)
	public String getSupplyList() {
		//retorna un json con la lista de platillos
		return null;
	}
*/
}
