package bootcamp.java2017.FinalProyect.REST;

import java.security.Principal;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import bootcamp.java2017.FinalProyect.DTO.ItemsDTO;
import bootcamp.java2017.FinalProyect.Model.Exceptions.ItemNotFoundException;
import bootcamp.java2017.FinalProyect.Model.Exceptions.NotEnoughMoneyException;
import bootcamp.java2017.FinalProyect.Model.Exceptions.UserNotFoundException;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Items.Item;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Items.ItemBag;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Items.ItemList;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Payments.FormOfPayment;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Payments.FormOfPaymentFactory;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Payments.Payments;
import bootcamp.java2017.FinalProyect.Service.ShoppingCart.ShoppingCartAPI;
import bootcamp.java2017.FinalProyect.Service.UserService.UserService;

@RestController
@RequestMapping("/cart")
public class ShoppingCartREST {

	@Autowired
	ShoppingCartAPI shoppingCart;
	@Autowired
	UserService userService;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> getItems(Principal principal) {
		Integer id = this.validateUser(principal);
		ItemList items = shoppingCart.getItems(id);
		ItemsDTO dto = new ItemsDTO();
		List<ItemBag> list = items.getUnmodifiableList();
		dto.setItems(list);
		
		return ResponseEntity.ok(dto);
	}


	@RequestMapping(method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<?> addItem(Principal principal, @RequestBody(required = true) Item item) {
		Integer id = this.validateUser(principal);
		this.shoppingCart.addItem(item, id);
		return ResponseEntity.ok().build();

	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> payItems(Principal principal, @RequestBody Payments formOfPayment) {
		try {
			Integer id = this.validateUser(principal);
			FormOfPayment payment = new FormOfPaymentFactory().getFormOfPayment(formOfPayment);
			this.shoppingCart.pay(payment, id);
			return ResponseEntity.ok().build();

		} catch (NotEnoughMoneyException e) {

			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("The user doesnt have enough money to pay for all the items in the cart");
		}
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteItem(Principal principal, @RequestBody(required = true) Item item) {
		try {
			Integer id = this.validateUser(principal);
			this.shoppingCart.removeItem(item, id);
			return ResponseEntity.ok().build();

		} catch (ItemNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The cart doesnt have that item");

		} 
	}
	

	private Integer validateUser(Principal principal) throws UserNotFoundException{
		return this.shoppingCart.getCartIdOfTheUser(this.userService.getByUsername(principal.getName()));
	}
}
