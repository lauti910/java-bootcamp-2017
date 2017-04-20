package bootcamp.java2017.FinalProyect.ServiceImpl.UserService;

import bootcamp.java2017.FinalProyect.Model.User;
import bootcamp.java2017.FinalProyect.Model.Exceptions.UserNotFoundException;
import bootcamp.java2017.FinalProyect.Service.UserService.UserService;

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

	@Override
	public User getUserById(Integer id) throws UserNotFoundException {
		return this.impl.getUserById(id);
	}

	@Override
	public User getByUsername(String username) throws UserNotFoundException {
		return this.impl.getByUsername(username);
	}

}
