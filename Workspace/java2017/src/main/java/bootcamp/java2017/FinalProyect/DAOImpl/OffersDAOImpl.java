package bootcamp.java2017.FinalProyect.DAOImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.query.Query;

import bootcamp.java2017.FinalProyect.DAO.Offer.OffersDAO;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Offer.Offer;

public class OffersDAOImpl implements OffersDAO {
	
	private HibernateSession session;

	public OffersDAOImpl() {
		this.session = HibernateSession.getInstance();
	}

	@Override
	public void save(Offer offer) {
		this.session.getCurrentSession().persist(offer);

	}

	@Override
	public Offer get(String offerName) {
		Query query = this.session.getCurrentSession().createQuery("From Offer O Where O.name = :oName");
		query.setParameter("oName", offerName);
		return (Offer) query.getSingleResult();
	}

	@Override
	public List<Offer> getAll() {
		Query query = this.session.getCurrentSession().createQuery("From Offer");
		return query.getResultList();
	}

	@Override
	public void remove(Offer offer) {
		this.session.getCurrentSession().remove(offer);

	}

}
