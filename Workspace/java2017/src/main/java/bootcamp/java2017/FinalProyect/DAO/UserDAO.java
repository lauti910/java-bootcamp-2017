package bootcamp.java2017.FinalProyect.DAO;

import bootcamp.java2017.FinalProyect.Model.User;

public interface UserDAO {
	public User getUser(Integer userId);
	
	public User getUserByUsernameAndPassword(String username, String password);
	
	public void persist(User user);
	
	public void update(User user);
	
	public void remove(User user);
}
