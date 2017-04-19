package bootcamp.java2017.FinalProyect.DAOImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.hibernate.query.Query;

import bootcamp.java2017.FinalProyect.DAO.OffersDAO;
import bootcamp.java2017.FinalProyect.DAOImpl.Session.Runner;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Offer.Offer;

public class OffersDAOImpl implements OffersDAO {
	


	@Override
	public void persist(Offer offer) {
		Runner.runInSession(() -> {
			Runner.getCurrentSession().persist(offer);
			return null;
		});

	}

	@Override
	public Offer getOffer(Integer offerId) {
		return Runner.runInSession(() -> {
			return Runner.getCurrentSession().get(Offer.class, offerId);
			
		});
	}

	@Override
	public List<Offer> getAll() {
		return Runner.runInSession(() -> {
			Query query = Runner.getCurrentSession().createQuery("From Offer");
			List<Offer> offers = query.getResultList();
			List<Offer> result = new ArrayList<Offer>();
			for(Offer o1: offers){
				if(result.stream().noneMatch(ofer -> ofer.contains(o1))){
					result.add(o1);
					result = result.stream().filter(ofer -> !o1.contains(ofer)).collect(Collectors.toList());
				}
			}
			return result;
		});
		
	}

	@Override
	public void remove(Offer offer) {
		Runner.runInSession(() -> {
			Runner.getCurrentSession().remove(offer);
			return null;
		});

	}

	@Override
	public void update(Offer offer) {
		Runner.runInSession(() -> {
			Runner.getCurrentSession().update(offer);
			return null;
		});
		
	}

}
