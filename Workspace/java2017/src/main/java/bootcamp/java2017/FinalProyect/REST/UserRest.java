package bootcamp.java2017.FinalProyect.REST;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import bootcamp.java2017.FinalProyect.DTO.UserDTO;
import bootcamp.java2017.FinalProyect.Model.User;
import bootcamp.java2017.FinalProyect.Model.Exceptions.DuplicatedUserException;
import bootcamp.java2017.FinalProyect.Model.Exceptions.UserNotFoundException;
import bootcamp.java2017.FinalProyect.Service.ShoppingCart.ShoppingCartAPI;
import bootcamp.java2017.FinalProyect.Service.UserService.UserService;

@Controller
@RequestMapping("/users")
public class UserREST {

	@Autowired
	private UserService service;

	@Autowired
	private ShoppingCartAPI cartService;

	@RequestMapping(method = RequestMethod.GET, path="/{id}/cart")
	@ResponseBody
	public ResponseEntity<?> getCartOfTheUser(@PathVariable(name="id") Integer id) {

		try {
			User user = service.getUserById(id);
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().replacePath("/{cartId}/items")
					.buildAndExpand(cartService.getCartIdOfTheUser(user)).toUri();
			return ResponseEntity.status(HttpStatus.FOUND).body(location);

		} catch (UserNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}
	@RequestMapping(method = RequestMethod.GET, path="/{id}")
	@ResponseBody
	public ResponseEntity<?> getUser(@PathVariable(name="id") Integer id) {

		try {
			User user = service.getUserById(id);
			UserDTO dto = new UserDTO();
			dto.setUsername(user.getUsername());
			dto.setFullName(user.getName());
			dto.setEmail(user.getEmail());
			dto.setId(user.getId());
			return ResponseEntity.ok(dto);

		} catch (UserNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}
	

	@RequestMapping(method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<?> register(@RequestBody User user) {
		try{
			
			service.createUser(user);
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
							.buildAndExpand(user.getId()).toUri();

			return ResponseEntity.created(location).build();
		}catch(DuplicatedUserException e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("There is already an user with that username");
		}
	}
	@RequestMapping(method = RequestMethod.POST, path="/{id}")
	@ResponseBody
	public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable(name="id") Integer id) {
		try{
			User userUpdated = service.getUserById(id);
			userUpdated.setCardNumber(user.getCardNumber());
			userUpdated.setEmail(user.getEmail());
			userUpdated.setName(user.getName());
			userUpdated.setUsername(user.getUsername());
			service.updateUser(userUpdated);
			return ResponseEntity.ok(userUpdated);
		}catch(UserNotFoundException e){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@RequestMapping(method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<?> delete(@RequestBody User userInfo) {
		try{
			
			User user = service.getUser(userInfo.getUsername(), userInfo.getPassword());
			service.removeUser(user);
			return ResponseEntity.ok().build();
		}catch(UserNotFoundException e){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

}