package bootcamp.java2017.ClaseServices.ServiceImpl.ShoppingCart;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import bootcamp.java2017.ClaseServices.DAOImpl.Offer.OffersDAOImpl;
import bootcamp.java2017.ClaseServices.Model.User;
import bootcamp.java2017.ClaseServices.Model.Exceptions.ItemNotFoundException;
import bootcamp.java2017.ClaseServices.Model.Exceptions.NotEnoughMoneyException;
import bootcamp.java2017.ClaseServices.Model.ShoppingCart.Items.Item;
import bootcamp.java2017.ClaseServices.Model.ShoppingCart.Items.ItemList;
import bootcamp.java2017.ClaseServices.Model.ShoppingCart.Items.ItemListImpl;
import bootcamp.java2017.ClaseServices.Model.ShoppingCart.Offer.Offer;
import bootcamp.java2017.ClaseServices.Model.ShoppingCart.Payments.CashPayment;
import bootcamp.java2017.ClaseServices.Model.ShoppingCart.Payments.FormOfPayment;
import bootcamp.java2017.ClaseServices.Model.ShoppingCart.Payments.Ticket;
import bootcamp.java2017.ClaseServices.Service.ShoppingCart.ShoppingCartAPI;

public class ShoppingCartImpl implements ShoppingCartAPI {

	private List<Item> items;
	private FormOfPayment payment;

	public ShoppingCartImpl() {
		this.items = new ArrayList<Item>();
		this.payment = new CashPayment();
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
		Double total = this.getTotalPrice();
		List<Offer> applyableOffers =  new OffersDAOImpl().getOffersList().stream()
										.filter(offer -> offer.canBeApplied(this.getItems()))
										.collect(Collectors.toList());
		Double amountSavedWithOffers = 0.0;
		for(Offer offer: applyableOffers){
			amountSavedWithOffers += offer.getPrice();
		}
		return total - amountSavedWithOffers;
	}

	@Override
	public void setFormOfPayment(FormOfPayment payment) {
		this.payment = payment;

	}

	@Override
	public ItemList getItems() {
		return new ItemListImpl(this.items);
	}

	@Override
	public Ticket pay(User user) throws NotEnoughMoneyException {
		Ticket ticket = this.payment.pay(user, this.getActualPrice(), this.getItems());
		
		this.items.clear();
		
		return ticket;

	}

}
