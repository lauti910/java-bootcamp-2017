package bootcamp.java2017.ClaseServices.ServiceImpl.ShoppingCart;

import bootcamp.java2017.ClaseServices.Model.User;
import bootcamp.java2017.ClaseServices.Model.Exceptions.ItemNotFoundException;
import bootcamp.java2017.ClaseServices.Model.Exceptions.NotEnoughMoneyException;
import bootcamp.java2017.ClaseServices.Model.ShoppingCart.Items.Item;
import bootcamp.java2017.ClaseServices.Model.ShoppingCart.Items.ItemList;
import bootcamp.java2017.ClaseServices.Model.ShoppingCart.Payments.FormOfPayment;
import bootcamp.java2017.ClaseServices.Model.ShoppingCart.Payments.Ticket;
import bootcamp.java2017.ClaseServices.Service.ShoppingCart.ShoppingCartAPI;

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
	public Ticket pay(User user) throws NotEnoughMoneyException {
		return this.web.pay(user);
	}

}
