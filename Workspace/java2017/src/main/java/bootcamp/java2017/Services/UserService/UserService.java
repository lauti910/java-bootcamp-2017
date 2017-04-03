package bootcamp.java2017.Services.UserService;

import bootcamp.java2017.Services.Exceptions.UserNotFoundException;

public interface UserService {
	
	public void createUser(User user);
	
	public User getUser(String username, String password) throws UserNotFoundException;
	
	public void updateUser(User userUpdated);
	
	public void removeUser(User user);
}
