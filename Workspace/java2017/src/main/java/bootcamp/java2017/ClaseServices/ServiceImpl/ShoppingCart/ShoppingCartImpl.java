package bootcamp.java2017.ClaseServices.ServiceImpl.ShoppingCart;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import bootcamp.java2017.ClaseServices.DAO.CartDAO;
import bootcamp.java2017.ClaseServices.DAOImpl.CartDAOImpl;
import bootcamp.java2017.ClaseServices.DAOImpl.OffersDAOImpl;
import bootcamp.java2017.ClaseServices.Model.User;
import bootcamp.java2017.ClaseServices.Model.Exceptions.ItemNotFoundException;
import bootcamp.java2017.ClaseServices.Model.Exceptions.NotEnoughMoneyException;
import bootcamp.java2017.ClaseServices.Model.ShoppingCart.Cart;
import bootcamp.java2017.ClaseServices.Model.ShoppingCart.Items.Item;
import bootcamp.java2017.ClaseServices.Model.ShoppingCart.Items.ItemImpl;
import bootcamp.java2017.ClaseServices.Model.ShoppingCart.Items.ItemList;
import bootcamp.java2017.ClaseServices.Model.ShoppingCart.Items.ItemListImpl;
import bootcamp.java2017.ClaseServices.Model.ShoppingCart.Offer.Offer;
import bootcamp.java2017.ClaseServices.Model.ShoppingCart.Payments.CashPayment;
import bootcamp.java2017.ClaseServices.Model.ShoppingCart.Payments.FormOfPayment;
import bootcamp.java2017.ClaseServices.Model.ShoppingCart.Payments.Ticket;
import bootcamp.java2017.ClaseServices.Service.UserServiceFactory;
import bootcamp.java2017.ClaseServices.Service.ShoppingCart.ShoppingCartAPI;

public class ShoppingCartImpl implements ShoppingCartAPI {

	CartDAO dao;
	public ShoppingCartImpl() {
		this.dao = new CartDAOImpl();
	}
	
	@Override
	public void addItem(Item item, Integer cartId) {
		//openSession
		Cart cart = this.dao.getCart(cartId);
		cart.addItem(item);
		this.dao.update(cart);
		
		//closeSession

	}

	@Override
	public void removeItem(Item item, Integer cartId) throws ItemNotFoundException {
		// dao.getCart
		// cart.remove
		// dao.updateCart
		Boolean removed = this.items.remove(item); // list.remove returns true
													// if the item is removed
		if (!removed) {
			throw new ItemNotFoundException();
		}
	}

	@Override
	public Double getTotalPrice(Integer cartId) {
		
		// dao.getCart
		// return cart.getTotalPrice
		Double sum = (double) 0;
		for(Item i: this.items){
			sum =  sum + i.getPrice();
		}
		return sum;
	}

	@Override
	public Double getActualPrice(Integer cartId) {
		//dao.getCart
		// return cart.getActualPrice
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
	public void setFormOfPayment(FormOfPayment payment, Integer cartId) {
		//dao.getCart
		//cart.setPayment
		//dao.updateCart
		this.payment = payment;

	}

	@Override
	public ItemList getItems(Integer cartId) {
		//return dao.getCart.getItems
		return new ItemListImpl(this.items);
	}

	@Override
	public Ticket pay(Integer cartId) throws NotEnoughMoneyException {
		//return dao.getCart.pay
		Ticket ticket = this.payment.pay(user, this.getActualPrice(), this.getItems());
		
		this.items.clear();
		
		return ticket;

	}

}
