package bootcamp.java2017.Services.ShoppingCart;

import java.util.ArrayList;
import java.util.List;

import bootcamp.java2017.Services.ShoppingCart.Exceptions.ItemNotFoundException;
import bootcamp.java2017.Services.ShoppingCart.Exceptions.NotEnoughMoneyException;
import bootcamp.java2017.Services.ShoppingCart.Interfaces.FormOfPayment;
import bootcamp.java2017.Services.ShoppingCart.Interfaces.Item;
import bootcamp.java2017.Services.ShoppingCart.Interfaces.ShoppingCartAPI;

public class ShoppingCartImpl implements ShoppingCartAPI {

	List<Item> items;

	public ShoppingCartImpl() {
		this.items = new ArrayList<Item>();
	}

	@Override
	public void addItem(Item item) {
		this.items.add(item);

	}

	@Override
	public void removeItem(Item item) throws ItemNotFoundException {
		Boolean removed = this.items.remove(item); // list.remove returns true
													// if the item is removed
		if (!removed) {
			throw new ItemNotFoundException();
		}
	}

	@Override
	public Double getTotalPrice() {
		Double sum = (double) 0;
		for(Item i: this.items){
			sum =  sum + i.getPrice();
		}
		return sum;
	}

	@Override
	public Double getActualPrice() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setFormOfPayment(FormOfPayment payment) {
		// TODO Auto-generated method stub

	}

	@Override
	public ItemList getItems() {
		return new ItemListImpl(this.items);
	}

	@Override
	public void pay() throws NotEnoughMoneyException {
		// TODO Auto-generated method stub

	}

}
