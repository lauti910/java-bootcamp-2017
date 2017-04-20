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

import bootcamp.java2017.FinalProyect.Model.Exceptions.ItemNotFoundException;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Items.Category;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Items.Item;
import bootcamp.java2017.FinalProyect.Service.Item.ItemService;

@Controller
@RequestMapping(path="/items")
public class ItemREST {
	
	@Autowired
	ItemService service;
	
	@RequestMapping(method= RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(this.service.getAll());
	}
	
	@RequestMapping(method= RequestMethod.GET, path="/{category}")
	@ResponseBody
	public ResponseEntity<?> getFromCategory(@PathVariable(name="category") Category category){
		return ResponseEntity.ok(this.service.getItemsFromCategory(category));
	}
	
	@RequestMapping(method= RequestMethod.GET, path="/{category}/{name}")
	@ResponseBody
	public ResponseEntity<?> getByCategoryAndName(@PathVariable(name="category") Category category, @PathVariable(name="name") String name){
		try{
			Item item = this.service.getItemByNameAndCategory(name, category);
			return ResponseEntity.ok(item);
		}catch(ItemNotFoundException e){
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("item of the category " + category + " with name " + name + "not found");
		}
	}
	
	@RequestMapping(method= RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<?> createItem(@RequestBody(required=true) Item item){
		this.service.createItem(item);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{category}/{name}")
				.buildAndExpand(item.getCategory(), item.getName()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@RequestMapping(method= RequestMethod.POST, path="/{category}/{name}")
	@ResponseBody
	public ResponseEntity<?> updateItem(@RequestBody(required=true) Item updatedItem, @PathVariable(name="category") Category category, @PathVariable(name="name") String name){
		try{
			Item item = this.service.getItemByNameAndCategory(name, category);
			item.setCategory(updatedItem.getCategory());
			item.setName(updatedItem.getName());
			item.setPrice(updatedItem.getPrice());
			this.service.updateItem(item);
			return ResponseEntity.ok().build();
			
		}catch(ItemNotFoundException e){
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("item of the category " + category + " with name " + name + "not found");
		}
	}
	@RequestMapping(method= RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<?> deleteItem(@RequestBody(required=true) Item item){
		this.service.removeItem(item);
		return ResponseEntity.ok().build();
	}

}