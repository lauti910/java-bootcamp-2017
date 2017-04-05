package bootcamp.java2017.ClaseServices.Model.ShoppingCart.Payments;

import bootcamp.java2017.ClaseServices.Model.User;
import bootcamp.java2017.ClaseServices.Model.Exceptions.NotEnoughMoneyException;
import bootcamp.java2017.ClaseServices.Model.ShoppingCart.Items.ItemList;

public class CashPayment implements FormOfPayment {

	@Override
	public Ticket pay(User user, Double price, ItemList items) throws NotEnoughMoneyException {
		Double actualPrice = price - items.getMostExpensiveItem().getPrice() * 0.9;
		return new Ticket(items, price, actualPrice, "Cash");
	}

}
