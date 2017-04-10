package bootcamp.java2017.ClaseServices.Model.ShoppingCart.Payments;

import javax.persistence.Entity;

import bootcamp.java2017.ClaseServices.Model.User;
import bootcamp.java2017.ClaseServices.Model.Exceptions.NotEnoughMoneyException;
import bootcamp.java2017.ClaseServices.Model.ShoppingCart.Items.ItemList;

@Entity
public class CreditCardPayment implements FormOfPayment {

	@Override
	public Ticket pay(User user, Double price, ItemList items) throws NotEnoughMoneyException {
		Double actualPrice = price - (price * 0.1);
		CreditCard card = new CreditCard(user.getName(), user.getCardNumber());
		
		card.pay(actualPrice);
		return new Ticket(items,price, actualPrice, "Credit Card");
	}

}
