package bootcamp.java2017.Services.UserService;

import bootcamp.java2017.Services.Exceptions.UserNotFoundException;

public class UserServiceWebImpl implements UserService {

	private UserService web;

	public UserServiceWebImpl(){
		//TODO: web = somthing to call the web api
	}

	@Override
	public void createUser(User user) {
		this.web.createUser(user);
		
	}

	@Override
	public User getUser(String username, String password) throws UserNotFoundException {
		return this.web.getUser(username, password);
	}

	@Override
	public void updateUser(User userUpdated) {
		this.web.updateUser(userUpdated);
		
	}

	@Override
	public void removeUser(User user) {
		this.web.removeUser(user);
		
	}

}
