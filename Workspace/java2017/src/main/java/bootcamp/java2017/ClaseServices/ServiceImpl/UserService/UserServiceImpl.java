package bootcamp.java2017.ClaseServices.ServiceImpl.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import bootcamp.java2017.ClaseServices.Model.User;
import bootcamp.java2017.ClaseServices.Model.Exceptions.UserNotFoundException;
import bootcamp.java2017.ClaseServices.Service.UserService.UserService;

public class UserServiceImpl implements UserService {

	private List<User> database;

	public UserServiceImpl() {
		this.database = new ArrayList<User>();

	}

	@Override
	public void createUser(User user) {
		this.database.add(user);

	}

	@Override
	public User getUser(String username) throws UserNotFoundException {
		Optional<User> opUser = this.database.stream()
								.filter(user -> user.getUsername() == username)
								.findAny();
		
		/* if the user is found, returns the user
		 * else throw the exception
		 */
		return opUser.orElseThrow(()-> new UserNotFoundException());

	}

	@Override
	public void updateUser(User userUpdated) {
		for(User user: this.database){
			if(user.getUsername() == userUpdated.getUsername()){
				this.database.remove(user);
				this.database.add(userUpdated);
				break;
			}
		}

	}

	@Override
	public void removeUser(User user) {
		this.database.remove(user);
	}

}
