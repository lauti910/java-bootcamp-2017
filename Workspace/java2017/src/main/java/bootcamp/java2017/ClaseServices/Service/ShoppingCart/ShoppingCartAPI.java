package bootcamp.java2017.ClaseServices.Service.ShoppingCart;

import bootcamp.java2017.ClaseServices.Model.User;
import bootcamp.java2017.ClaseServices.Model.Exceptions.ItemNotFoundException;
import bootcamp.java2017.ClaseServices.Model.Exceptions.NotEnoughMoneyException;
import bootcamp.java2017.ClaseServices.Model.ShoppingCart.Items.Item;
import bootcamp.java2017.ClaseServices.Model.ShoppingCart.Items.ItemList;
import bootcamp.java2017.ClaseServices.Model.ShoppingCart.Payments.CashPayment;
import bootcamp.java2017.ClaseServices.Model.ShoppingCart.Payments.CreditCardPayment;
import bootcamp.java2017.ClaseServices.Model.ShoppingCart.Payments.FormOfPayment;
import bootcamp.java2017.ClaseServices.Model.ShoppingCart.Payments.PayPalPayment;
import bootcamp.java2017.ClaseServices.Model.ShoppingCart.Payments.Ticket;

public interface ShoppingCartAPI {
	/**
	 * Adds an item to the cart
	 * 
	 * @param item
	 *            the item that will be added to the cart
	 * @see Item
	 */
	public void addItem(Item item);

	/**
	 * Removes an item from the cart and throws an exception when you try to
	 * remove an item that isnt there
	 * 
	 * @param item
	 * @throws ItemNotFoundException
	 * @see Item
	 */
	public void removeItem(Item item) throws ItemNotFoundException;

	/**
	 * @return the price of all the items without discounts
	 */
	public Double getTotalPrice();

	/**
	 * @return the price of all the items with discounts and offers
	 */
	public Double getActualPrice();

	/**
	 * Sets the form of payment to use to pay. Default is cash
	 * 
	 * @param payment
	 *            the form of payment to be used
	 * @see FormOfPayment
	 * @see CashPayment
	 * @see PayPalPayment
	 * @see CreditCardPayment
	 */
	public void setFormOfPayment(FormOfPayment payment);

	/**
	 * @return a list of items that isn't modifiable
	 * @see ItemList
	 */
	public ItemList getItems();

	/**
	 * Pay for all the items you have in the cart
	 * 
	 * @param user
	 *            The user who pays
	 * @return a ticket with the information of the transaction
	 * @throws NotEnoughMoneyException
	 *             in case there is not enough money in the user accounts for
	 *             his items
	 * @see User
	 * @see FormOfPayment
	 * @see Ticket
	 */
	public Ticket pay(User user) throws NotEnoughMoneyException;

}
