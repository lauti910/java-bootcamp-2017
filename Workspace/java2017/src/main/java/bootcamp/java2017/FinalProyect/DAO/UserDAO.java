package bootcamp.java2017.FinalProyect.DAO;

import java.util.Optional;

import bootcamp.java2017.FinalProyect.Model.User;

public interface UserDAO {
	public Optional<User> getUser(Integer userId);
	
	public Optional<User> getUserByUsernameAndPassword(String username, String password);
	
	public void persist(User user);
	
	public void update(User user);
	
	public void remove(User user);
}
