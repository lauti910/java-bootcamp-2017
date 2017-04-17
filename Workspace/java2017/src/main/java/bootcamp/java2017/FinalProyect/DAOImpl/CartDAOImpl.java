package bootcamp.java2017.FinalProyect.DAOImpl;

import org.hibernate.query.Query;

import bootcamp.java2017.FinalProyect.DAO.CartDAO;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Cart;

public class CartDAOImpl implements CartDAO {
	
	private HibernateSession session;
	
	public CartDAOImpl(){
		this.session = HibernateSession.getInstance();
	}

	@Override
	public Cart getCart(Integer cartId) {
		return session.getCurrentSession().get(Cart.class, cartId);
	}

	@Override
	public Cart getCartByUserId(Integer userId) {
		Query query = session.getCurrentSession().createQuery("From Cart C Where C.user.id = :user_id");
		query.setParameter("user_id", userId);
		return (Cart) query.getSingleResult();
	}

	@Override
	public void persist(Cart cart) {
		session.getCurrentSession().persist(cart);
		
	}

	@Override
	public void update(Cart cart) {
		session.getCurrentSession().update(cart);
		
	}

	@Override
	public void remove(Cart cart) {
		session.getCurrentSession().remove(cart);
		
	}

}
