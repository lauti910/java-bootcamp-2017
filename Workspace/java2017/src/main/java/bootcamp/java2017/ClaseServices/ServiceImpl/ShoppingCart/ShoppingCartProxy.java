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
	public void addItem(Item item, Integer cartId) {
		this.implementation.addItem(item, cartId);
		
	}

	@Override
	public void removeItem(Item item, Integer cartId) throws ItemNotFoundException {
		this.implementation.removeItem(item, cartId);
		
	}

	@Override
	public Double getTotalPrice(Integer cartId) {
		return this.implementation.getTotalPrice(cartId);
	}

	@Override
	public Double getActualPrice(Integer cartId) {
		return this.implementation.getActualPrice(cartId);
	}

	@Override
	public void setFormOfPayment(FormOfPayment payment, Integer cartId) {
		this.implementation.setFormOfPayment(payment, cartId);
		
	}

	@Override
	public ItemList getItems(Integer cartId) {
		return this.implementation.getItems(cartId);
	}

	@Override
	public Ticket pay(Integer cartId) throws NotEnoughMoneyException {
		return this.implementation.pay(cartId);
	}

}
