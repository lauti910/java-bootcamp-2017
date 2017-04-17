package bootcamp.java2017.DAO;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import bootcamp.java2017.FinalProyect.DAO.CartDAO;
import bootcamp.java2017.FinalProyect.DAOImpl.CartDAOImpl;
import bootcamp.java2017.FinalProyect.DAOImpl.HibernateSession;
import bootcamp.java2017.FinalProyect.Model.User;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Cart;

public class ShoppingCartDAOTest {

	CartDAO dao;
	HibernateSession session;
	
	@Before
	public void setUp(){
		this.dao = new CartDAOImpl();
		this.session = HibernateSession.getInstance();
	}
	@Test
	public void test_ACartIsPersistedInTheDatabase() {
		Cart cart = new Cart(new User("asd", "asd"));
		this.session.openCurrentSessionwithTransaction();
		
		this.dao.persist(cart);
		
		assertEquals(this.dao.getCart(cart.getId()), cart);
		
		this.session.closeCurrentSessionwithTransaction();
		
	}

}
