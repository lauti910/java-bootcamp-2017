package bootcamp.java2017.Services.ShoppingCart.Offers;

import java.util.List;

public interface OffersDAO {
	/**
	 * Saves an offer in the database
	 * 
	 * @param offer
	 *            The offer to be saved
	 */
	public void save(Offer offer);

	/**
	 * 
	 * @param offerName
	 * @return the offer with name = offername
	 */
	public Offer get(String offerName);

	/**
	 * 
	 * @return the list of offers in the database
	 */
	public List<Offer> getOffersList();

	/**
	 * Removes an offer from the database
	 * 
	 * @param offer
	 *            The offer to be removed
	 */
	public void remove(Offer offer);
}
