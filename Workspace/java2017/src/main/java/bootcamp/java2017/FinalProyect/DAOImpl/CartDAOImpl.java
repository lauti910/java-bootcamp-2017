package bootcamp.java2017.FinalProyect.DAOImpl;

import java.util.Optional;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.query.Query;

import bootcamp.java2017.FinalProyect.DAO.CartDAO;
import bootcamp.java2017.FinalProyect.DAOImpl.Session.Runner;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Cart;

public class CartDAOImpl implements CartDAO {
		
	@Override
	public Optional<Cart> getCart(Integer cartId) {
		return Runner.runInSession(() -> {

			return Optional.ofNullable(Runner.getCurrentSession().get(Cart.class, cartId));
		});
		
	}

	@Override
	public Optional<Cart> getCartByUserId(Integer userId) {
		return Runner.runInSession(() -> {
			Session session = Runner.getCurrentSession();
			Query query = session.createQuery("From Cart c Where c.user.id = :user_id");
			query.setParameter("user_id", userId);
			try{
				return Optional.of((Cart)query.getSingleResult());
			}catch(NoResultException e){
				System.out.println("There is no user with id:" + userId);
				return Optional.empty();
			}
		});
	}

	@Override
	public void persist(Cart cart) {
		Runner.runInSession(() -> {
			Runner.getCurrentSession().persist(cart);
			return null;
		});
	}

	@Override
	public void update(Cart cart) {
		Runner.runInSession(() -> {
			Runner.getCurrentSession().update(cart);
			return null;
		});
	}

	@Override
	public void remove(Cart cart) {
		Runner.runInSession(() -> {
			Runner.getCurrentSession().remove(cart);
			return null;
		});
		
	}

}
