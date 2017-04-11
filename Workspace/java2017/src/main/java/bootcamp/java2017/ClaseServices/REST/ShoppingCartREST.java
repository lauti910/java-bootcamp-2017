package bootcamp.java2017.ClaseServices.REST;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.hibernate.boot.jaxb.cfg.spi.JaxbCfgHibernateConfiguration.JaxbCfgSessionFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;

import bootcamp.java2017.ClaseServices.Model.User;
import bootcamp.java2017.ClaseServices.Model.Exceptions.UserNotFoundException;
import bootcamp.java2017.ClaseServices.Model.ShoppingCart.Items.ItemList;
import bootcamp.java2017.ClaseServices.Service.UserServiceFactory;
import bootcamp.java2017.ClaseServices.Service.ShoppingCart.ShoppingCartAPI;
import bootcamp.java2017.ClaseServices.Service.UserService.UserService;

@Path("/{cartID}")
public class ShoppingCartREST {
	
	ShoppingCartAPI shoppingCart;

	@GET
	@Path("/items")
	public Response getItems(@PathParam("cartId") Integer id) {

		try {
			
			ItemList items = shoppingCart.getItems(id);
			String json = new ObjectMapper().writeValueAsString(items);

			return Response.ok(json, MediaType.APPLICATION_JSON).build();
			
		}
		catch (JsonProcessingException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity("The items werent transformed to json").build();
		}
	}
	
}
