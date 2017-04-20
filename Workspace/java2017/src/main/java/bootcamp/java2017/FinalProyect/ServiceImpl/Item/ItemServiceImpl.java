package bootcamp.java2017.FinalProyect.ServiceImpl.Item;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import bootcamp.java2017.FinalProyect.DAO.ItemDAO;
import bootcamp.java2017.FinalProyect.DAOImpl.ItemDAOImpl;
import bootcamp.java2017.FinalProyect.DAOImpl.Session.Runner;
import bootcamp.java2017.FinalProyect.Model.Exceptions.ItemNotFoundException;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Items.Category;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Items.Item;
import bootcamp.java2017.FinalProyect.Service.Item.ItemService;

@Service
public class ItemServiceImpl implements ItemService{
	
	private ItemDAO dao;
	
	public ItemServiceImpl() {
		this.dao = new ItemDAOImpl();
	}

	@Override
	public void createItem(Item item) {
		Runner.runInSession(() -> {
			Optional<Item> opItem = this.dao.getItemByNameAndCategory(item.getName(), item.getCategory());
			if(!opItem.isPresent()){
				this.dao.persist(item);
			}
			return null;
		});
		
	}

	@Override
	public Item getItemByNameAndCategory(String name, Category category) throws ItemNotFoundException {
		return Runner.runInSession(() -> {
			Optional<Item> opItem = this.dao.getItemByNameAndCategory(name, category);
			return opItem.orElseThrow(() -> new ItemNotFoundException());
		});
	}

	@Override
	public List<Item> getItemsFromCategory(Category category) {
		return Runner.runInSession(() -> {
			return this.dao.getItemsFromCategory(category);
		});
	}

	@Override
	public List<Item> getAll() {
		return Runner.runInSession(() -> {
			return this.dao.getAll();
		});
	}

	@Override
	public void updateItem(Item item) {
		Runner.runInSession(() -> {
			this.dao.update(item);
			return null;
		});
	}

	@Override
	public void removeItem(Item item) {
		Runner.runInSession(() -> {
			this.dao.remove(item);
			return null;
		});
		
	}

}
