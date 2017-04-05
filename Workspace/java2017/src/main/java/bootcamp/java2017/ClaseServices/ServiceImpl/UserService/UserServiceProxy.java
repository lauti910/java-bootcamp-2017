package bootcamp.java2017.ClaseServices.ServiceImpl.UserService;

import bootcamp.java2017.ClaseServices.Model.User;
import bootcamp.java2017.ClaseServices.Model.Exceptions.UserNotFoundException;
import bootcamp.java2017.ClaseServices.Service.UserService.UserService;

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
