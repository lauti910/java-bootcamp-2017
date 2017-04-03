package bootcamp.java2017.Services.ShoppingCart.Items;

public interface ItemList {
	/**
	 * 
	 * @param item
	 * @return if the list contains the item
	 * @see Item
	 */
	public Boolean contains(Item item);

	/**
	 * prints the list
	 */
	public void show();

	/**
	 * 
	 * @return if the list is empty, true in case it is, false if it doesn't
	 */
	public Boolean isEmpty();

	/**
	 * 
	 * @return the cheapest item found in the list
	 * @see Item
	 */
	public Item getCheapestItem();

	/**
	 * 
	 * @return the most expensive item found in the list
	 * @see Item
	 */
	public Item getMostExpensiveItem();

}
