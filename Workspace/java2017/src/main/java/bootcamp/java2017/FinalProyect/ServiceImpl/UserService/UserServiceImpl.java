package bootcamp.java2017.FinalProyect.ServiceImpl.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import bootcamp.java2017.FinalProyect.DAO.UserDAO;
import bootcamp.java2017.FinalProyect.DAOImpl.UserDAOImpl;
import bootcamp.java2017.FinalProyect.DAOImpl.Session.Runner;
import bootcamp.java2017.FinalProyect.Model.User;
import bootcamp.java2017.FinalProyect.Model.Exceptions.UserNotFoundException;
import bootcamp.java2017.FinalProyect.Service.UserService.UserService;


@Service
public class UserServiceImpl implements UserService {

	private UserDAO dao;

	public UserServiceImpl() {
		this.dao = new UserDAOImpl();

	}

	@Override
	public void createUser(User user) {
		Runner.runInSession(() -> {
			this.dao.persist(user);
			return null;
		});

	}

	@Override
	public User getUser(String username, String password) throws UserNotFoundException {
		return Runner.runInSession(() -> {
			Optional<User> opUser = this.dao.getUserByUsernameAndPassword(username, password);
			
			/* if the user is found, returns the user
			 * else throw the exception
			 */
			return opUser.orElseThrow(()-> new UserNotFoundException());
		});
	}

	@Override
	public void updateUser(User userUpdated) {

		Runner.runInSession(() -> {
			this.dao.update(userUpdated);
			return null;
		});
	}

	@Override
	public void removeUser(User user) {

		Runner.runInSession(() -> {
			this.dao.remove(user);
			return null;
		});
	}

}
