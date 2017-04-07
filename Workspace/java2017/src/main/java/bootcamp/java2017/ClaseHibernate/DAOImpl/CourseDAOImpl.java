package bootcamp.java2017.ClaseHibernate.DAOImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import bootcamp.java2017.ClaseHibernate.DAO.CourseDAO;
import bootcamp.java2017.ClaseHibernate.Model.Course;

public class CourseDAOImpl implements CourseDAO {
	private HibernateUtils utils;

	/**
	 * Should be done after you open a session, and you should close the session
	 * when you finish
	 * 
	 * Persist the course in the database
	 * @param course
	 */
	@Override
	public void persist(Course course) {
		this.utils.getCurrentSession().persist(course);
	}

	/**
	 * Should be done after you open a session, and you should close the session
	 * when you finish
	 * 
	 * @param id
	 * @return Returns the Course with id == id
	 */
	@Override
	public Course findById(Integer id) {
		// TODO Auto-generated method stub
		return this.utils.getCurrentSession().get(Course.class, id);
	}

	/**
	 * Should be done after you open a session, and you should close the session
	 * when you finish
	 * deletes the course given
	 * @param course
	 */
	@Override
	public void delete(Course course) {
		this.utils.getCurrentSession().delete(course);

	}

	/**
	 * Should be done after you open a session, and you should close the session
	 * when you finish
	 * 
	 * Updates the course given
	 * @param course
	 */
	@Override
	public void update(Course course) {
		this.utils.getCurrentSession().update(course);

	}

	/**
	 * Should be done after you open a session, and you should close the session
	 * when you finish
	 * 
	 * @return Returns all the courses in the database
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Course> getAll() {
		return (List<Course>) this.utils.getCurrentSession().createQuery("from Course").list();
	}

	/**
	 * Should be done after you open a session, and you should close the session
	 * when you finish
	 * 
	 * this delets all the courses in the databases. Use it carefully
	 */
	@Override
	public void deleteAll() {
		List<Course> all = this.getAll();
		for (Course c : all) {
			this.delete(c);
		}
	}

}
