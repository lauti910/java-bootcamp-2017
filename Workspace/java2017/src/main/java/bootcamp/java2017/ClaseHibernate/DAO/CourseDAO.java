package bootcamp.java2017.ClaseHibernate.DAO;

import java.util.List;

import bootcamp.java2017.ClaseHibernate.Model.Course;

public interface CourseDAO {
	
	/**
	 * Persist the course in the database
	 * 
	 * Should be done after you open a session, and you should close the session
	 * when you finish.
	 * Example: 
	 * 		HibernateSession.getInstance().openCurrentSessionWithTransaction();
	 * 		...
	 * 		persist(...)
	 * 		...
	 * 		HibernateSession.getInstance().closeCurrentSessionWithTransaction();
	 * 
	 * @param course
	 */
	public void persist(Course course);
	
	/**
	 * Returns the Course with id == id
	 * 
	 * Should be done after you open a session, and you should close the session
	 * when you finish.
	 * Example: 
	 * 		HibernateSession.getInstance().openCurrentSessionWithTransaction();
	 * 		...
	 * 		findById(...)
	 * 		...
	 * 		HibernateSession.getInstance().closeCurrentSessionWithTransaction();
	 * @param id
	 * @return Course
	 */
	public Course findById(Integer id);
	
	/**
	 * Deletes the course given in the database
	 * 
	 * Should be done after you open a session, and you should close the session
	 * when you finish.
	 * Example: 
	 * 		HibernateSession.getInstance().openCurrentSessionWithTransaction();
	 * 		...
	 * 		delete(...)
	 * 		...
	 * 		HibernateSession.getInstance().closeCurrentSessionWithTransaction();
	 * @param course
	 */
	public void delete(Course course);
	
	/**
	 * Updates the course given
	 * 
	 * Should be done after you open a session, and you should close the session
	 * when you finish.
	 * Example: 
	 * 		HibernateSession.getInstance().openCurrentSessionWithTransaction();
	 * 		...
	 * 		update(...)
	 * 		...
	 * 		HibernateSession.getInstance().closeCurrentSessionWithTransaction();
	 * @param course
	 */
	public void update(Course course);
	
	/**
	 * Returns all the courses in the database
	 * 
	 * Should be done after you open a session, and you should close the session
	 * when you finish.
	 * Example: 
	 * 		HibernateSession.getInstance().openCurrentSessionWithTransaction();
	 * 		...
	 * 		getAll()
	 * 		...
	 * 		HibernateSession.getInstance().closeCurrentSessionWithTransaction();
	 * 
	 * @return List<Course>
	 */
	public List<Course> getAll();
	
	/**
	 * DELETES ALL THE COURSES IN THE DATABASE. Use it carefully.
	 * 
	 * Should be done after you open a session, and you should close the session
	 * when you finish.
	 * Example: 
	 * 		HibernateSession.getInstance().openCurrentSessionWithTransaction();
	 * 		...
	 * 		deleteAll()
	 * 		...
	 * 		HibernateSession.getInstance().closeCurrentSessionWithTransaction();
	 */
	public void deleteAll();
}
