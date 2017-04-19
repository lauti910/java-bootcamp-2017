package bootcamp.java2017.FinalProyect.REST;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import bootcamp.java2017.FinalProyect.Model.User;
import bootcamp.java2017.FinalProyect.Model.Exceptions.UserNotFoundException;
import bootcamp.java2017.FinalProyect.Service.ShoppingCart.ShoppingCartAPI;
import bootcamp.java2017.FinalProyect.Service.UserService.UserService;

@Controller
@RequestMapping("/users")
public class UserRest {

	@Autowired
	private UserService service;

	@Autowired
	private ShoppingCartAPI cartService;

	@RequestMapping(method = RequestMethod.GET, path = "/")
	@ResponseBody
	public ResponseEntity<?> login(@RequestBody UserLoginInfo info) {

		try {
			User user = service.getUser(info.getUsername(), info.getPassword());
			return ResponseEntity.ok(cartService.getCartIdOfTheUser(user));

		} catch (UserNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@RequestMapping(method = RequestMethod.PUT, path = "/")
	@ResponseBody
	public ResponseEntity<?> register(@RequestBody User user) {
		service.createUser(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}/items")
						.buildAndExpand(cartService.getCartIdOfTheUser(user)).toUri();

		return ResponseEntity.created(location).build();
	}

	@RequestMapping(method = RequestMethod.POST, path = "/")
	@ResponseBody
	public ResponseEntity<?> update(@RequestBody User user) {
		service.updateUser(user);
		return ResponseEntity.ok().build();
	}

	@RequestMapping(method = RequestMethod.DELETE, path = "/")
	@ResponseBody
	public ResponseEntity<?> delete(@RequestBody User user) {
		service.removeUser(user);
		return ResponseEntity.ok().build();
	}

}
