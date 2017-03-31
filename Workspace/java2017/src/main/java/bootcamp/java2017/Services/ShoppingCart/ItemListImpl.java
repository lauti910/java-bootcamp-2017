package bootcamp.java2017.Services.ShoppingCart;

import java.util.List;

import bootcamp.java2017.Services.ShoppingCart.Interfaces.Item;

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

}
