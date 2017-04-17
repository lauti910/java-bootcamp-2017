package bootcamp.java2017.FinalProyect.DAOImpl;

import org.hibernate.query.Query;

import bootcamp.java2017.FinalProyect.DAO.UserDAO;
import bootcamp.java2017.FinalProyect.Model.User;

public class UserDAOImpl implements UserDAO{
	
	HibernateSession session;
	
	public UserDAOImpl(){
		this.session = HibernateSession.getInstance();
	}

	@Override
	public User getUser(Integer userId) {
		return this.session.getCurrentSession().get(User.class, userId);
	}

	@Override
	public User getUserByUsernameAndPassword(String username, String password) {
		Query<User> query = this.session.getCurrentSession().createQuery("FROM User U Where U.username = :user AND U.password = :pass");
		query.setParameter("user", username);
		query.setParameter("pass", password);
		
		return query.getSingleResult();
	}

	@Override
	public void persist(User user) {
		this.session.getCurrentSession().persist(user);
		
	}

	@Override
	public void update(User user) {
		this.session.getCurrentSession().update(user);
		
	}

	@Override
	public void remove(User user) {
		this.session.getCurrentSession().remove(user);
		
	}

}
