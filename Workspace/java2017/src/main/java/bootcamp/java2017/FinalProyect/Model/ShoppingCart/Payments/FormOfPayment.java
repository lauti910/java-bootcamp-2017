package bootcamp.java2017.FinalProyect.Model.ShoppingCart.Payments;

import bootcamp.java2017.FinalProyect.Model.User;
import bootcamp.java2017.FinalProyect.Model.Exceptions.NotEnoughMoneyException;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Items.ItemList;

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
