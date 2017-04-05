package bootcamp.java2017.Services;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import bootcamp.java2017.ClaseServices.Model.User;
import bootcamp.java2017.ClaseServices.Model.Exceptions.UserNotFoundException;
import bootcamp.java2017.ClaseServices.Service.UserService.UserService;
import bootcamp.java2017.ClaseServices.ServiceImpl.UserService.UserServiceImpl;

public class UserServiceTest {
	
	private UserService userService;
	private User user;
	
	@Before
	public void setUp(){
		this.userService = new UserServiceImpl();
		this.user = Mockito.mock(User.class);
		
	}

	@Test
	public void test_YouCanCreateAndGetAnUser() throws UserNotFoundException{
		Mockito.doReturn("lauti910").when(this.user).getUsername();
		Mockito.doReturn("1234").when(this.user).getPassword();
		
		this.userService.createUser(this.user);
		assertEquals(this.userService.getUser("lauti910", "1234"), this.user); 
	}
	
	@Test(expected = UserNotFoundException.class)
	public void test_IfYouTryToGetAnUserThatDoesntExist_ItThrowsAnException() throws UserNotFoundException{
		this.userService.getUser("lala", "lolo");
	}
	
	@Test
	public void test_YouCanUpdateAnUser() throws UserNotFoundException{
		Mockito.doReturn("lauti910").when(this.user).getUsername();
		Mockito.doReturn("lauti910@gmail.com").when(this.user).getEmail();
		Mockito.doReturn("1234").when(this.user).getPassword();
		
		User updatedUser = Mockito.mock(User.class);
		Mockito.doReturn("lauti910").when(updatedUser).getUsername();
		Mockito.doReturn("lauti910@hotmail.com").when(updatedUser).getEmail();
		Mockito.doReturn("1234").when(updatedUser).getPassword();
		
		// gmail -> hotmail
		this.userService.createUser(this.user);
		this.userService.updateUser(updatedUser);
		
		assertEquals(this.userService.getUser("lauti910", "1234"), updatedUser);
		
	}
	
	@Test(expected= UserNotFoundException.class)
	public void test_YouCanRemoveAnUser() throws UserNotFoundException{
		Mockito.doReturn("lauti910").when(this.user).getUsername();
		Mockito.doReturn("1234").when(this.user).getPassword();
		
		this.userService.createUser(this.user);
		this.userService.removeUser(this.user);

		this.userService.getUser("lauti910", "1234");
	}
}
