package bootcamp.java2017.Services.ShoppingCart;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import bootcamp.java2017.Services.ShoppingCart.Interfaces.OffersDAO;

public class OffersDAOImpl implements OffersDAO {

	private List<Offer> dataBase;

	public OffersDAOImpl() {
		dataBase = new ArrayList<Offer>();
	}

	@Override
	public void save(Offer offer) {
		this.dataBase.add(offer);

	}

	@Override
	public Offer get(String offerName) {
		Optional<Offer> opOffer = this.dataBase.stream()
									.filter(offer -> offer.getName().equalsIgnoreCase(offerName))
									.findAny();
		if(opOffer.isPresent()){
			return opOffer.get();
		}else{
			return null; //TODO: throw an exception
		}
	}

	@Override
	public List<Offer> getOffersList() {
		return this.dataBase;
	}

	@Override
	public void remove(Offer offer) {
		this.dataBase.remove(offer);

	}

}
