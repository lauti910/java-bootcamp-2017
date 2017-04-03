package bootcamp.java2017.Services.ShoppingCart.Payments;

import bootcamp.java2017.Services.Exceptions.NotEnoughMoneyException;
import bootcamp.java2017.Services.ShoppingCart.Items.ItemList;
import bootcamp.java2017.Services.UserService.User;

public class CreditCardPayment implements FormOfPayment {

	@Override
	public Ticket pay(User user, Double price, ItemList items) throws NotEnoughMoneyException {
		Double actualPrice = price - (price * 0.1);
		CreditCard card = new CreditCard(user.getName(), user.getCardNumber());
		
		card.pay(actualPrice);
		return new Ticket(items,price, actualPrice, "Credit Card");
	}

}
