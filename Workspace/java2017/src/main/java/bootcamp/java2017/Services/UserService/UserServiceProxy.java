package bootcamp.java2017.Services.UserService;

import bootcamp.java2017.Services.Exceptions.UserNotFoundException;

public class UserServiceProxy implements UserService{
	
	private UserService impl;

	public UserServiceProxy(UserService implementation){
		this.impl = implementation;
	}

	@Override
	public void createUser(User user) {
		this.impl.createUser(user);
		
	}

	@Override
	public User getUser(String username, String password) throws UserNotFoundException {
		return this.impl.getUser(username, password);
	}

	@Override
	public void updateUser(User userUpdated) {
		this.impl.updateUser(userUpdated);
		
	}

	@Override
	public void removeUser(User user) {
		this.impl.removeUser(user);
		
	}

}
