package bootcamp.java2017.DAO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import bootcamp.java2017.FinalProyect.DAO.CartDAO;
import bootcamp.java2017.FinalProyect.DAO.UserDAO;
import bootcamp.java2017.FinalProyect.DAOImpl.CartDAOImpl;
import bootcamp.java2017.FinalProyect.DAOImpl.UserDAOImpl;
import bootcamp.java2017.FinalProyect.DAOImpl.Session.Runner;
import bootcamp.java2017.FinalProyect.Model.User;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Cart;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Items.Category;
import bootcamp.java2017.FinalProyect.Model.ShoppingCart.Items.Item;

public class UserDAOTest {
	UserDAO dao;
	User user;
	
	@Before
	public void setUp(){
		this.user = new User("asd","asd");
		this.dao = new UserDAOImpl();
	}
	@Test
	public void test_AnUserIsPersistedInTheDatabase() {
		Runner.runInSession(() -> {
			this.dao.persist(user);
			
			assertEquals(this.dao.getUser(user.getId()).get(), user);
			
			this.dao.remove(user);
			return null;
		});
		
	}
	
	@Test
	public void test_GetAnUserFromTheDatabaseWithItsUsernameAndPassword(){
		Runner.runInSession(() -> {

			this.dao.persist(user);
			
			assertEquals(this.dao.getUserByUsernameAndPassword("asd", "asd").get(), user);
			
			this.dao.remove(user);
			return null;
		});
	}
	
	@Test
	public void test_removeAnUserFromTheDatabase(){
		Runner.runInSession(() -> {

			this.dao.persist(user);
			this.dao.remove(user);
			
			assertEquals(this.dao.getUser(user.getId()).orElse(null), null);
			return null;
		});
	}
	
	@Test
	public void test_updateAnUserInTheDatabase(){
		Runner.runInSession(() -> {
			this.dao.persist(user);
			user.setEmail("email@gmail.com");
			this.dao.update(user);
			
			assertEquals(this.dao.getUser(user.getId()).get().getEmail(), "email@gmail.com");
			return null;
		});
	}
}
