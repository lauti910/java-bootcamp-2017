package bootcamp.java2017.FinalProyect.DAOImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.hibernate.query.Query;

import bootcamp.java2017.FinalProyect.DAO.OffersDAO;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Offer.Offer;

public class OffersDAOImpl implements OffersDAO {
	
	private HibernateSession session;

	public OffersDAOImpl() {
		this.session = HibernateSession.getInstance();
	}

	@Override
	public void persist(Offer offer) {
		this.session.getCurrentSession().persist(offer);

	}

	@Override
	public Offer getOffer(Integer offerId) {
		return this.session.getCurrentSession().get(Offer.class, offerId);
	}

	@Override
	public List<Offer> getAll() {
		Query query = this.session.getCurrentSession().createQuery("From Offer");
		List<Offer> offers = query.getResultList();
		List<Offer> result = new ArrayList<Offer>();
		for(Offer o1: offers){
			if(result.stream().noneMatch(ofer -> ofer.contains(o1))){
				result.add(o1);
				result = result.stream().filter(ofer -> !o1.contains(ofer)).collect(Collectors.toList());
			}
		}
		return result;
	}

	@Override
	public void remove(Offer offer) {
		this.session.getCurrentSession().remove(offer);

	}

	@Override
	public void update(Offer offer) {
		this.session.getCurrentSession().update(offer);
		
	}

}
