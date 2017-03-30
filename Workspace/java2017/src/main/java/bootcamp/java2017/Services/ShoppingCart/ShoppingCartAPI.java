package bootcamp.java2017.Services.ShoppingCart;

public interface ShoppingCartAPI {
	public void addItem(Item item);
	
	// throws an exeption when you try to remove an item that isnt there
	public void removeItem(Item item) throws ItemNotFoundExeption;
	
	public Double getTotalPrice();
	
	public void setFormOfPayment(FormOfPayment payment);
	
	public ItemList getItems();
	
	//throws an exeption when there isnt enought money to pay for the items you want
	public void pay() throws NotEnoughMoneyExeption;
	
	
}
