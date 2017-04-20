package bootcamp.java2017.FinalProyect.Service.Item;

import java.util.List;

import bootcamp.java2017.FinalProyect.Model.Exceptions.ItemNotFoundException;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Items.Category;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Items.Item;

public interface ItemService {

	
	public void createItem(Item item);
	public Item getItemByNameAndCategory(String name, Category category) throws ItemNotFoundException;
	public List<Item> getItemsFromCategory(Category category);
	public List<Item> getAll();
	public void updateItem(Item item);
	public void removeItem(Item item);
}
