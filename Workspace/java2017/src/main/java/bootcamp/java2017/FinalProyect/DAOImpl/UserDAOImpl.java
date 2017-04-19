package bootcamp.java2017.FinalProyect.DAOImpl;

import java.util.Optional;

import javax.persistence.NoResultException;

import org.hibernate.query.Query;

import bootcamp.java2017.FinalProyect.DAO.UserDAO;
import bootcamp.java2017.FinalProyect.DAOImpl.Session.Runner;
import bootcamp.java2017.FinalProyect.Model.User;

public class UserDAOImpl implements UserDAO{
	

	@Override
	public Optional<User> getUser(Integer userId) {
		return Runner.runInSession(() -> {
			return Optional.ofNullable(Runner.getCurrentSession().get(User.class, userId));
			
		});
	}

	@Override
	public Optional<User> getUserByUsernameAndPassword(String username, String password) {
		return Runner.runInSession(() -> {

			Query<User> query = Runner.getCurrentSession().createQuery("FROM User U Where U.username = :user AND U.password = :pass");
			query.setParameter("user", username);
			query.setParameter("pass", password);
			try{

				return Optional.of(query.getSingleResult());
			}catch(NoResultException e){
				return Optional.empty();
			}
			
		});
	}

	@Override
	public void persist(User user) {
		Runner.runInSession(() -> {
			Runner.getCurrentSession().persist(user);
			return null;
			
		});
	}

	@Override
	public void update(User user) {
		Runner.runInSession(() -> {
			Runner.getCurrentSession().update(user);
			return null;
			
		});
		
	}

	@Override
	public void remove(User user) {
		Runner.runInSession(() -> {
			Runner.getCurrentSession().remove(user);
			return null;
			
		});
		
	}

}
