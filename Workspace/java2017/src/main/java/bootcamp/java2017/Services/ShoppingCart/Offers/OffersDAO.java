package bootcamp.java2017.Services.ShoppingCart.Offers;

import java.util.List;

public interface OffersDAO {
	public void save(Offer offer);
	public Offer get(String offerName);
	public List<Offer> getOffersList();
	public void remove(Offer offer);
}
