package bootcamp.java2017.Services.ShoppingCart;

import bootcamp.java2017.Services.ShoppingCart.Interfaces.Item;

public interface ItemList {
	
	public Boolean contains(Item item);
	
	public void show();
	
	public Boolean isEmpty();
	
}
