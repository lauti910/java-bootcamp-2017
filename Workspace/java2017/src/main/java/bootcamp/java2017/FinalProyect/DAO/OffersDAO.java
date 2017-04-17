package bootcamp.java2017.FinalProyect.DAO;

import java.util.List;

import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Offer.Offer;

public interface OffersDAO {
	/**
	 * Saves an offer in the database
	 * 
	 * @param offer
	 *            The offer to be saved
	 */
	public void persist(Offer offer);

	/**
	 * 
	 * @param offerName
	 * @return the offer with id = offerId
	 */
	public Offer getOffer(Integer offerId);

	/**
	 * 
	 * @return the list of offers in the database
	 */
	public List<Offer> getAll();

	/**
	 * Removes an offer from the database
	 * 
	 * @param offer
	 *            The offer to be removed
	 */
	public void remove(Offer offer);
	
	public void update(Offer offer);
}
