package bootcamp.java2017.Services;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import bootcamp.java2017.FinalProyect.Model.User;
import bootcamp.java2017.FinalProyect.Model.Exceptions.UserNotFoundException;
import bootcamp.java2017.FinalProyect.Service.UserService.UserService;
import bootcamp.java2017.FinalProyect.ServiceImpl.UserService.UserServiceImpl;

public class UserServiceTest {
	
	private UserService userService;
	private User user;
	
	@Before
	public void setUp(){
		this.userService = new UserServiceImpl();
		this.user = new User("asd", "asd");
		
	}

	@Test
	public void test_YouCanCreateAndGetAnUser() throws UserNotFoundException{
		
		this.userService.createUser(this.user);
		assertEquals(this.userService.getUser("asd", "asd").getId(), this.user.getId()); 
		this.userService.removeUser(this.user);
	}
	
	@Test(expected = UserNotFoundException.class)
	public void test_IfYouTryToGetAnUserThatDoesntExist_ItThrowsAnException() throws UserNotFoundException{
		this.userService.getUser("lala", "lala");
	}
	
	@Test
	public void test_YouCanUpdateAnUser() throws UserNotFoundException{

		this.userService.createUser(this.user);
		
		this.user.setEmail("lauti910@gmail.com");
		
		// gmail -> hotmail
		this.userService.updateUser(this.user);
		
		assertEquals(this.userService.getUser("asd", "asd").getId(), this.user.getId());
		
		this.userService.removeUser(user);
		
	}
	
	@Test(expected= UserNotFoundException.class)
	public void test_YouCanRemoveAnUser() throws UserNotFoundException{
		
		this.userService.createUser(this.user);
		this.userService.removeUser(this.user);

		this.userService.getUser("asd", "asd");
	}
}
