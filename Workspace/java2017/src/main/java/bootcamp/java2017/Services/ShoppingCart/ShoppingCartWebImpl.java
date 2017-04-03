package bootcamp.java2017.Services.ShoppingCart;

import bootcamp.java2017.Services.Exceptions.ItemNotFoundException;
import bootcamp.java2017.Services.Exceptions.NotEnoughMoneyException;
import bootcamp.java2017.Services.ShoppingCart.Items.Item;
import bootcamp.java2017.Services.ShoppingCart.Items.ItemList;
import bootcamp.java2017.Services.ShoppingCart.Payments.FormOfPayment;
import bootcamp.java2017.Services.UserService.User;

public class ShoppingCartWebImpl implements ShoppingCartAPI {
	
	ShoppingCartAPI web;
	
	public ShoppingCartWebImpl() {
		//TODO: web = something to connect to the web api
	}

	@Override
	public void addItem(Item item) {
		this.web.addItem(item);
		
	}

	@Override
	public void removeItem(Item item) throws ItemNotFoundException {
		this.web.removeItem(item);
		
	}

	@Override
	public Double getTotalPrice() {
		return this.web.getTotalPrice();
	}

	@Override
	public Double getActualPrice() {
		return this.web.getActualPrice();
	}

	@Override
	public void setFormOfPayment(FormOfPayment payment) {
		this.web.setFormOfPayment(payment);
		
	}

	@Override
	public ItemList getItems() {
		return this.web.getItems();
	}

	@Override
	public void pay(User user) throws NotEnoughMoneyException {
		this.web.pay(user);
	}

}
