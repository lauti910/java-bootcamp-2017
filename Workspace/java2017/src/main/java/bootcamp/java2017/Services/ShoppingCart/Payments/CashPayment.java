package bootcamp.java2017.Services.ShoppingCart.Payments;

import bootcamp.java2017.Services.Exceptions.NotEnoughMoneyException;
import bootcamp.java2017.Services.ShoppingCart.ItemList;
import bootcamp.java2017.Services.ShoppingCart.Interfaces.FormOfPayment;
import bootcamp.java2017.Services.UserService.User;

public class CashPayment implements FormOfPayment {

	@Override
	public Ticket pay(User user, Double price, ItemList items) throws NotEnoughMoneyException {
		Double actualPrice = price - items.mostExpensiveItem().getPrice() * 0.9;
		return new Ticket(items, price, actualPrice, "Cash");
	}

}
