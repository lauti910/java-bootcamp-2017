package bootcamp.java2017.Services.ShoppingCart.Items;

public interface ItemList {
	
	public Boolean contains(Item item);
	
	public void show();
	
	public Boolean isEmpty();

	public Item getCheapestItem();

	public Item mostExpensiveItem();
	
}
