package bootcamp.java2017.FinalProyect.Model.ShoppingCart.Payments;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import bootcamp.java2017.FinalProyect.Model.User;
import bootcamp.java2017.FinalProyect.Model.Exceptions.NotEnoughMoneyException;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Items.ItemList;


public class CashPayment implements FormOfPayment {

	@Override
	public Ticket pay(User user, Double price, ItemList items) throws NotEnoughMoneyException {
		Double actualPrice = price;
		if(!items.isEmpty()){
			actualPrice = price - items.getMostExpensiveItem().getPrice() * 0.9;
		}
		return new Ticket(items, price, actualPrice, "Cash");
	}

}
