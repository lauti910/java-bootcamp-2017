package bootcamp.java2017.FinalProyect.DTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Items.Category;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Items.Item;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Items.ItemBag;

public class ItemsDTO {
	
	private Integer total;
	private Map<Category, Integer> categories;
	private List<ItemDTO> items;
	
	public ItemsDTO(){
		this.total = 0;
		this.categories = new HashMap<Category, Integer>();
		this.items = new ArrayList<ItemDTO>();
	}
	
	public Integer getTotal() {
		return total;
	}
	public Map<Category, Integer> getCategories() {
		return categories;
	}
	public List<ItemDTO> getItems() {
		return items;
	}
	public void setItems(List<ItemBag> list) {
		this.items = new ArrayList<ItemDTO>();
		this.categories = new HashMap<Category, Integer>();
		this.total = 0;
		for(ItemBag ib: list){
			this.addToCategory(ib.getItem().getCategory(), ib.getQuantity());
			this.items.add(new ItemDTO(ib));
			this.total += ib.getQuantity();
		}
	}
	
	public void addToCategory(Category category, Integer amount){
		this.categories.put(category, this.categories.getOrDefault(category, 0) + amount);
	}
	
	
}
