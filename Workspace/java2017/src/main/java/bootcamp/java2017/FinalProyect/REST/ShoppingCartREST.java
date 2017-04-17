package bootcamp.java2017.FinalProyect.REST;

import java.io.IOException;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import bootcamp.java2017.FinalProyect.Model.Exceptions.ItemNotFoundException;
import bootcamp.java2017.FinalProyect.Model.Exceptions.NotEnoughMoneyException;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Items.Item;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Items.Item;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Items.ItemList;
import bootcamp.java2017.FinalProyect.Service.ShoppingCart.ShoppingCartAPI;

@Controller
@RequestMapping("/{cartID}")
public class ShoppingCartREST {

	@Autowired
	ShoppingCartAPI shoppingCart;

	ObjectMapper mapper;

	public ShoppingCartREST() {
		this.mapper = new ObjectMapper();
	}

	@RequestMapping(method = RequestMethod.GET, path = "/items")
	@ResponseBody
	public ResponseEntity<?> getItems(@PathVariable("cartID") Integer id) {

		try {

			ItemList items = shoppingCart.getItems(id);
			String json = this.mapper.writeValueAsString(items);

			return ResponseEntity.ok(json);

		} catch (JsonProcessingException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("The items werent transformed to json");
		}
	}

	@RequestMapping(method = RequestMethod.PUT, path = "/items")
	@ResponseBody
	public ResponseEntity<?> addItem(@PathVariable("cartID") Integer id, @RequestBody(required = true) String itemJson) {

		try {

			Item item = this.mapper.readValue(itemJson, Item.class);
			this.shoppingCart.addItem(item, id);

			return ResponseEntity.ok().build();

		} catch (Exception e) { // Possible exceptions:
								// JsonParseException,JsonMappingException,
								// IOException

			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("There is a problem in the item json");
		}

	}

	@RequestMapping(method = RequestMethod.POST, path = "/items")
	@ResponseBody
	public ResponseEntity<?> payItems(@PathVariable("cartID") Integer id) {
		try {

			this.shoppingCart.pay(id);
			return ResponseEntity.ok().build();
		} catch (NotEnoughMoneyException e) {

			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("The user doesnt have enough money to pay for all the items in the cart");
		}
	}

	@RequestMapping(method = RequestMethod.DELETE, path = "/items")
	public ResponseEntity<?> deleteItem(@PathVariable("cartID") Integer id, @RequestBody(required = true) String itemJson) {
		try {

			Item item = this.mapper.readValue(itemJson, Item.class);
			this.shoppingCart.removeItem(item, id);

			return ResponseEntity.ok().build();

		} catch (ItemNotFoundException e) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The cart doesnt have that item");
			
		} catch (Exception e) { // Possible exceptions:
								// JsonParseException,JsonMappingException,
								// IOException
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("There is a problem in the item json");
		}
	}
}
