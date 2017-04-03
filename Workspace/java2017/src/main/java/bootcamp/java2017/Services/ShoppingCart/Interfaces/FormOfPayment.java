package bootcamp.java2017.Services.ShoppingCart.Interfaces;

import bootcamp.java2017.Services.Exceptions.NotEnoughMoneyException;
import bootcamp.java2017.Services.ShoppingCart.ItemList;
import bootcamp.java2017.Services.ShoppingCart.Payments.Ticket;
import bootcamp.java2017.Services.UserService.User;

public interface FormOfPayment {
	
	public Ticket pay(User user, Double price, ItemList items) throws NotEnoughMoneyException;
}
