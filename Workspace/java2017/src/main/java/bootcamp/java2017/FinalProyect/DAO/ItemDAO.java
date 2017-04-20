package bootcamp.java2017.FinalProyect.DAO;

import java.util.List;
import java.util.Optional;

import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Items.Category;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Items.Item;

public interface ItemDAO {

	public Optional<Item> getItemByNameAndCategory(String name, Category category);

	public void persist(Item item);

	public List<Item> getItemsFromCategory(Category category);

	public List<Item> getAll();

	public void update(Item item);

	public void remove(Item item);

}
