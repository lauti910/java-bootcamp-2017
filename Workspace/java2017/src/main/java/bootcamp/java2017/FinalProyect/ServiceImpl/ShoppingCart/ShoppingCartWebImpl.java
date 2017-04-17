package bootcamp.java2017.FinalProyect.ServiceImpl.ShoppingCart;

import bootcamp.java2017.FinalProyect.Model.User;
import bootcamp.java2017.FinalProyect.Model.Exceptions.ItemNotFoundException;
import bootcamp.java2017.FinalProyect.Model.Exceptions.NotEnoughMoneyException;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Items.Item;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Items.ItemList;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Payments.FormOfPayment;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Payments.Ticket;
import bootcamp.java2017.FinalProyect.Service.ShoppingCart.ShoppingCartAPI;

public class ShoppingCartWebImpl implements ShoppingCartAPI {
	
	ShoppingCartAPI web;
	
	public ShoppingCartWebImpl() {
		//TODO: web = something to connect to the web api
	}

	@Override
	public void addItem(Item item, Integer cartId) {
		this.web.addItem(item, cartId);
		
	}

	@Override
	public void removeItem(Item item, Integer cartId) throws ItemNotFoundException {
		this.web.removeItem(item, cartId);
		
	}

	@Override
	public Double getTotalPrice(Integer cartId) {
		return this.web.getTotalPrice(cartId);
	}

	@Override
	public Double getActualPrice(Integer cartId) {
		return this.web.getActualPrice(cartId);
	}

	@Override
	public ItemList getItems(Integer cartId) {
		return this.web.getItems(cartId);
	}

	@Override
	public Ticket pay(FormOfPayment formOfPayment, Integer cartId) throws NotEnoughMoneyException {
		return this.web.pay(formOfPayment, cartId);
	}

	@Override
	public Integer getCartIdOfTheUser(User user) {
		return this.web.getCartIdOfTheUser(user);
	}

}
