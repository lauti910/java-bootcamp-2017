package bootcamp.java2017.FinalProyect.DAO.Offer;

import java.util.List;

import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Offer.Offer;

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
	public List<Offer> getAll();

	/**
	 * Removes an offer from the database
	 * 
	 * @param offer
	 *            The offer to be removed
	 */
	public void remove(Offer offer);
}
