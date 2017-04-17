package bootcamp.java2017.FinalProyect.Model.ShoppingCart.Payments;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import bootcamp.java2017.FinalProyect.Model.User;
import bootcamp.java2017.FinalProyect.Model.Exceptions.NotEnoughMoneyException;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Items.ItemList;

public class CreditCardPayment implements FormOfPayment {

	
	@Override
	public Ticket pay(User user, Double price, ItemList items) throws NotEnoughMoneyException {
		Double actualPrice = price - (price * 0.1);
		CreditCard card = new CreditCard(user.getName(), user.getCardNumber());
		
		card.pay(actualPrice);
		return new Ticket(items,price, actualPrice, "Credit Card");
	}

}
