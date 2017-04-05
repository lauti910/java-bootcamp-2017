package bootcamp.java2017.ClaseServices.Model.ShoppingCart.Items;

import java.util.Collections;
import java.util.List;

public class ItemListImpl implements ItemList {
	
	List<Item> items;

	public ItemListImpl(List<Item> items) {
		this.items = items;
	}

	@Override
	public Boolean contains(Item item) {
		return items.contains(item);
	}

	@Override
	public void show() {
		for(Item i: this.items){
			System.out.println(i.getName() + "......" + i.getPrice());
		}

	}

	@Override
	public Boolean isEmpty() {
		return this.items.isEmpty();
	}

	@Override
	public Item getCheapestItem() {
		Collections.sort(this.items, (i1, i2) -> i1.getPrice().compareTo(i2.getPrice()));
		return this.items.get(0);
	}

	@Override
	public Item getMostExpensiveItem() {
		Collections.sort(this.items, (i1, i2) -> i1.getPrice().compareTo(i2.getPrice()));
		return this.items.get(this.items.size() - 1);
	}

}
