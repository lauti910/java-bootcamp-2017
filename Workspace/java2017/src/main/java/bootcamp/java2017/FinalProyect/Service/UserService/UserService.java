package bootcamp.java2017.FinalProyect.Service.UserService;

import bootcamp.java2017.FinalProyect.Model.User;
import bootcamp.java2017.FinalProyect.Model.Exceptions.UserNotFoundException;

public interface UserService {
	/**
	 * Creates an user
	 * 
	 * @param user
	 *            the user to be created
	 */
	public void createUser(User user);

	/**
	 * 
	 * @param username
	 *            the username of the user
	 * @param password
	 *            the pass of the user
	 * @return The user with username = username and password = password
	 * @throws UserNotFoundException
	 *             in case no such user exist, or the password is wrong
	 */
	public User getUser(String username, String password) throws UserNotFoundException;

	/**
	 * 
	 * @param userUpdated
	 *            the updated user, it remplaces the old user with same username
	 */
	public void updateUser(User userUpdated);

	/**
	 * Removes an user
	 * 
	 * @param user
	 *            the user to be removed
	 */
	public void removeUser(User user);
}
