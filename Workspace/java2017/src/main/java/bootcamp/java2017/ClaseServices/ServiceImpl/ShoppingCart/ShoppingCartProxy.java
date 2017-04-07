package bootcamp.java2017.ClaseServices.ServiceImpl.ShoppingCart;

import bootcamp.java2017.ClaseServices.Model.User;
import bootcamp.java2017.ClaseServices.Model.Exceptions.ItemNotFoundException;
import bootcamp.java2017.ClaseServices.Model.Exceptions.NotEnoughMoneyException;
import bootcamp.java2017.ClaseServices.Model.ShoppingCart.Items.Item;
import bootcamp.java2017.ClaseServices.Model.ShoppingCart.Items.ItemList;
import bootcamp.java2017.ClaseServices.Model.ShoppingCart.Payments.FormOfPayment;
import bootcamp.java2017.ClaseServices.Model.ShoppingCart.Payments.Ticket;
import bootcamp.java2017.ClaseServices.Service.ShoppingCart.ShoppingCartAPI;

public class ShoppingCartProxy implements ShoppingCartAPI{
	
	private ShoppingCartAPI implementation;

	public ShoppingCartProxy(ShoppingCartAPI implementation){
		this.implementation = implementation;
	}

	@Override
	public void addItem(Item item) {
		this.implementation.addItem(item);
		
	}

	@Override
	public void removeItem(Item item) throws ItemNotFoundException {
		this.implementation.removeItem(item);
		
	}

	@Override
	public Double getTotalPrice() {
		return this.implementation.getTotalPrice();
	}

	@Override
	public Double getActualPrice() {
		return this.implementation.getActualPrice();
	}

	@Override
	public void setFormOfPayment(FormOfPayment payment) {
		this.implementation.setFormOfPayment(payment);
		
	}

	@Override
	public ItemList getItems() {
		return this.implementation.getItems();
	}

	@Override
	public Ticket pay(User user) throws NotEnoughMoneyException {
		return this.implementation.pay(user);
	}

}