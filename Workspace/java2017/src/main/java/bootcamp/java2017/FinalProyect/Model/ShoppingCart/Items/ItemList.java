package bootcamp.java2017.FinalProyect.Model.ShoppingCart.Items;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ItemList {
	
	private List<Item> items;

	public ItemList(List<ItemBag> items) {
		this.items = new ArrayList<Item>();
		for(ItemBag bag: items){
			this.items.add(bag.getItem());
		}
	}

	public Boolean contains(Item item) {
		return items.stream().anyMatch(i -> i.getId() == item.getId());
	}

	
	public void show() {
		for(Item i: this.items){
			System.out.println(i.getName() + "......" + i.getPrice());
		}

	}

	
	public Boolean isEmpty() {
		return this.items.isEmpty();
	}

	
	public Item getCheapestItem() {
		Collections.sort(this.items, (i1, i2) -> i1.getPrice().compareTo(i2.getPrice()));
		return this.items.get(0);
	}

	
	public Item getMostExpensiveItem() {
		Collections.sort(this.items, (i1, i2) -> i1.getPrice().compareTo(i2.getPrice()));
		return this.items.get(this.items.size() - 1);
	}

}
