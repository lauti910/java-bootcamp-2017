package bootcamp.java2017.Services.ShoppingCart;

public interface ShoppingCartAPI {
	
	//Adds an item to the cart
	public void addItem(Item item);
	
	//Removes an item from the cart
	//Throws an exception when you try to remove an item that isnt there
	public void removeItem(Item item) throws ItemNotFoundExeption;
	
	//Returns the price of all the items in the cart, without discounts
	public Double getTotalPrice();
	
	//Returns the price of all the items in the cart, including discounts
	public Double getActualPrice();
	
	//Sets the form of payment to pay afterwards
	//Should be a default form in case no-one is selected
	public void setFormOfPayment(FormOfPayment payment);
	
	//Returns the list of items added to the cart.
	//The ItemList shouldn't be modifiable
	public ItemList getItems();
	
	//Pay for the items through a form of payment
	//Throws an exception when there isn't enough money to pay for the items you want
	public void pay() throws NotEnoughMoneyExeption;
	
	
}
