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
	 * Adds an item to the cart with id == cartId
	 * 
	 * @param item
	 *            the item that will be added to the cart
	 * @param cartId
	 *            The id of the cart
	 * @see Item
	 * @see Cart
	 */
	public void addItem(Item item, Integer cartId);

	/**
	 * Removes an item from the cart with id == cartId and throws an exception
	 * when you try to remove an item that isn't there
	 * 
	 * @param item
	 *            The item to be removed
	 * @param cartId
	 *            The id of the cart
	 * @throws ItemNotFoundException
	 * @see Item
	 * @see Cart
	 */
	public void removeItem(Item item, Integer cartId) throws ItemNotFoundException;

	/**
	 * @param cartId
	 *            the Id of the cart
	 * @return the price of all the items without discounts
	 */
	public Double getTotalPrice(Integer cartId);

	/**
	 * @param cartId
	 *            the Id of the cart
	 * @return the price of all the items with discounts and offers
	 */
	public Double getActualPrice(Integer cartId);

	/**
	 * Sets the form of payment to use to pay, in the cart with id == cartId. Default is cash
	 * @param cartId
	 *            the Id of the cart
	 * @param payment
	 *            the form of payment to be used
	 * @see FormOfPayment
	 * @see CashPayment
	 * @see PayPalPayment
	 * @see CreditCardPayment
	 */
	public void setFormOfPayment(FormOfPayment payment, Integer cartId);

	/**
	 * @param cartId
	 *            the Id of the cart
	 * @return a list of items that isn't modifiable
	 * @see ItemList
	 */
	public ItemList getItems(Integer cartId);

	/**
	 * Pay for all the items you have in the cart
	 * 
	 * @param cartId
	 *            the Id of the cart
	 * @return a ticket with the information of the transaction
	 * @throws NotEnoughMoneyException
	 *             in case there is not enough money in the user accounts for
	 *             his items
	 * @see Cart
	 * @see FormOfPayment
	 * @see Ticket
	 */
	public Ticket pay(Integer cartId) throws NotEnoughMoneyException;
	
	public Integer getCartIdOfTheUser(User user);

}
