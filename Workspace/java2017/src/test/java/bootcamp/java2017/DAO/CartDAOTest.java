package bootcamp.java2017.DAO;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import bootcamp.java2017.FinalProyect.DAO.CartDAO;
import bootcamp.java2017.FinalProyect.DAOImpl.CartDAOImpl;
import bootcamp.java2017.FinalProyect.DAOImpl.HibernateSession;
import bootcamp.java2017.FinalProyect.DAOImpl.UserDAOImpl;
import bootcamp.java2017.FinalProyect.Model.User;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Cart;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Items.Category;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Items.Item;

public class CartDAOTest {

	CartDAO dao;
	HibernateSession session;
	User user;
	Cart cart;
	
	@Before
	public void setUp(){
		this.user = new User("asd", "asd");
		this.cart = new Cart(this.user);
		this.dao = new CartDAOImpl();
		this.session = HibernateSession.getInstance();
	}
	@Test
	public void test_ACartIsPersistedInTheDatabase() {
		this.session.openCurrentSessionwithTransaction();
		
		this.dao.persist(cart);
		
		assertEquals(this.dao.getCart(cart.getId()), cart);
		
		this.dao.remove(cart);
		this.session.closeCurrentSessionwithTransaction();
		
	}
	
	@Test
	public void test_YouCanGetACartByItsUserId(){
		this.session.openCurrentSessionwithTransaction();
		
		this.dao.persist(cart);
		
		assertEquals(this.dao.getCartByUserId(user.getId()), cart);
		
		this.dao.remove(cart);
		
		this.session.closeCurrentSessionwithTransaction();
	}
	
	@Test
	public void test_WhenYouRemoveACartFromTheDatabase_ItAlsoRemovesTheUser(){
		this.session.openCurrentSessionwithTransaction();
		
		this.dao.persist(cart);
		this.dao.remove(cart);
		
		assertEquals(new UserDAOImpl().getUser(user.getId()), null);
		
		this.session.closeCurrentSessionwithTransaction();
		
	}
	
	@Test
	public void test_updateACartInTheDatabase(){
		Item item = new Item(0.0, "asd", Category.BEVERAGE);
		this.session.openCurrentSessionwithTransaction();
		
		this.dao.persist(cart);
		
		cart.addItem(item);
		
		this.dao.update(cart);
		
		assertTrue(this.dao.getCart(cart.getId()).getItems().contains(item));
		
		this.dao.remove(cart);
		this.session.closeCurrentSessionwithTransaction();
	}

}
