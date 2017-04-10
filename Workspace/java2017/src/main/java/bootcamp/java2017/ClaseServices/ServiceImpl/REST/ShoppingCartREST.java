package bootcamp.java2017.ClaseServices.ServiceImpl.REST;

import javax.ws.rs.GET;
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
import bootcamp.java2017.ClaseServices.Service.UserService.UserService;

@Path("/cart")
public class ShoppingCartREST {

	private UserService userService = new UserServiceFactory().getLocalService();

	@GET
	@Path("/{username}/items")
	public Response getItems(@PathParam("username") String username) {

		// TODO: validate(username)
		if (username == null || username.isEmpty()) {
			return Response.status(Response.Status.BAD_REQUEST).entity("The username can't be empty").build();
		}
		try {

			User user = this.userService.getUser(username);
			ItemList items = user.getShoppingCart().getItems();
			String json = new ObjectMapper().writeValueAsString(items);

			return Response.ok(json, MediaType.APPLICATION_JSON).build();
			
		} catch (UserNotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND)
					.entity("User " + username + " not found").build();
			
		} catch (JsonProcessingException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity("The items werent transformed to json").build();
		}
	}
}
