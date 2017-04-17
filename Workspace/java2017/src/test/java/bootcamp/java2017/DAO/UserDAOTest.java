package bootcamp.java2017.DAO;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import bootcamp.java2017.FinalProyect.DAO.CartDAO;
import bootcamp.java2017.FinalProyect.DAO.UserDAO;
import bootcamp.java2017.FinalProyect.DAOImpl.CartDAOImpl;
import bootcamp.java2017.FinalProyect.DAOImpl.HibernateSession;
import bootcamp.java2017.FinalProyect.DAOImpl.UserDAOImpl;
import bootcamp.java2017.FinalProyect.Model.User;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Cart;

public class UserDAOTest {
	UserDAO dao;
	HibernateSession session;
	User user;
	
	@Before
	public void setUp(){
		this.user = new User("asd","asd");
		this.dao = new UserDAOImpl();
		this.session = HibernateSession.getInstance();
	}
	@Test
	public void test_AnUserIsPersistedInTheDatabase() {
		this.session.openCurrentSessionwithTransaction();
		
		this.dao.persist(user);
		
		assertEquals(this.dao.getUser(user.getId()), user);
		
		this.dao.remove(user);
		
		this.session.closeCurrentSessionwithTransaction();
		
	}
	
	@Test
	public void test_GetAnUserFromTheDatabaseWithItsUsernameAndPassword(){
		this.session.openCurrentSessionwithTransaction();
		
		this.dao.persist(user);
		
		assertEquals(this.dao.getUserByUsernameAndPassword("asd", "asd"), user);
		
		this.dao.remove(user);
		
		this.session.closeCurrentSessionwithTransaction();
	}
	
	@Test
	public void test_removeAnUserFromTheDatabase(){
		this.session.openCurrentSessionwithTransaction();
		
		this.dao.persist(user);
		this.dao.remove(user);
		
		assertEquals(this.dao.getUser(user.getId()), null);
		
		this.session.closeCurrentSessionwithTransaction();
		
	}
	
	@Test
	public void test_updateAnUserInTheDatabase(){
		this.session.openCurrentSessionwithTransaction();
		
		this.dao.persist(user);
		
		user.setEmail("email@gmail.com");
		
		this.dao.update(user);
		
		assertEquals(this.dao.getUser(user.getId()).getEmail(), "email@gmail.com");
		
		this.session.closeCurrentSessionwithTransaction();
	}
}
