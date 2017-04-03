package bootcamp.java2017.Services.ShoppingCart.Payments;

import bootcamp.java2017.Services.Exceptions.NotEnoughMoneyException;
import bootcamp.java2017.Services.ShoppingCart.Items.ItemList;
import bootcamp.java2017.Services.UserService.User;

public interface FormOfPayment {
	/**
	 * 
	 * @param user
	 *            The user who pays
	 * @param price
	 *            The actual price of the items with the offers applied
	 * @param items
	 *            The list of items
	 * @return A ticket with the information of the transaction
	 * @throws NotEnoughMoneyException
	 * @see CashPayment
	 * @see CreditCardPayment
	 * @see PayPalPayment
	 * @see Ticket
	 * @see ItemList
	 */
	public Ticket pay(User user, Double price, ItemList items) throws NotEnoughMoneyException;
}
