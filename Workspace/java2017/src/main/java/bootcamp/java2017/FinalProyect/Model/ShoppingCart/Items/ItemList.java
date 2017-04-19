package bootcamp.java2017.FinalProyect.Model.ShoppingCart.Items;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ItemList {
	
	private List<ItemBag> items;

	public ItemList(List<ItemBag> items) {
		this.items = items;
	}

	public Boolean contains(Item item) {
		return items.stream().anyMatch(i -> i.getItem().getId() == item.getId());
	}

	
	public void show() {
		for(ItemBag i: this.items){
			System.out.println(i.getItem().getName() + "......" + i.getItem().getPrice() + " x" + i.getQuantity());
		}

	}

	
	public Boolean isEmpty() {
		return this.items.isEmpty();
	}

	
	public Item getCheapestItem() {
		Collections.sort(this.items, (i1, i2) -> i1.getItem().getPrice().compareTo(i2.getItem().getPrice()));
		return this.items.get(0).getItem();
	}

	
	public Item getMostExpensiveItem() {
		Collections.sort(this.items, (i1, i2) -> i1.getItem().getPrice().compareTo(i2.getItem().getPrice()));
		return this.items.get(this.items.size() - 1).getItem();
	}

	public List<ItemBag> getUnmodifiableList() {
		return Collections.unmodifiableList(this.items);
	}

}
