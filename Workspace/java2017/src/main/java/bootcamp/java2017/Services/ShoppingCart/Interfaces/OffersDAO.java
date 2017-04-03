package bootcamp.java2017.Services.ShoppingCart.Interfaces;

import java.util.List;

import bootcamp.java2017.Services.ShoppingCart.Offer;

public interface OffersDAO {
	public void save(Offer offer);
	public Offer get(String offerName);
	public List<Offer> getOffersList();
	public void remove(Offer offer);
}
