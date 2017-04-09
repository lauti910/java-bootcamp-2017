package bootcamp.java2017.ClaseHibernate.DAO;

import java.util.List;

import bootcamp.java2017.ClaseHibernate.Model.Persons.Teacher;

public interface TeacherDAO {
	
	/**
	 * Persist the teacher in the database
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
	 * @param teacher
	 */
	public void persist(Teacher teacher);
	
	/**
	 * Returns the teacher with id == id
	 *  
	 * Should be done after you open a session, and you should close the session
	 * when you finish.
	 * Example: 
	 * 		HibernateSession.getInstance().openCurrentSessionWithTransaction();
	 * 		...
	 * 		findById(...)
	 * 		...
	 * 		HibernateSession.getInstance().closeCurrentSessionWithTransaction();
	 * 
	 * @param id
	 * @return Teacher
	 */
	public Teacher findById(Integer id);
	
	/**
	 * Deletes the teacher in the database
	 * 
	 * Should be done after you open a session, and you should close the session
	 * when you finish.
	 * Example: 
	 * 		HibernateSession.getInstance().openCurrentSessionWithTransaction();
	 * 		...
	 * 		delete(...)
	 * 		...
	 * 		HibernateSession.getInstance().closeCurrentSessionWithTransaction();
	 * 
	 * @param teacher
	 */
	public void delete(Teacher teacher);
	
	/**
	 * Updates the teacher in the database 
	 * Should be done after you open a session, and you should close the session
	 * when you finish.
	 * Example: 
	 * 		HibernateSession.getInstance().openCurrentSessionWithTransaction();
	 * 		...
	 * 		update(...)
	 * 		...
	 * 		HibernateSession.getInstance().closeCurrentSessionWithTransaction();
	 * 
	 * @param teacher
	 */
	public void update(Teacher teacher);
	
	/**
	 * Returns all the teachers in the database
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
	 * @return List<Teacher>
	 */
	public List<Teacher> getAll();
	
	/**
	 * DELETES ALL THE TEACHERS in the database, be careful
	 * 
	 * Should be done after you open a session, and you should close the session
	 * when you finish.
	 * Example: 
	 * 		HibernateSession.getInstance().openCurrentSessionWithTransaction();
	 * 		...
	 * 		deleteAll()
	 * 		...
	 * 		HibernateSession.getInstance().closeCurrentSessionWithTransaction();
	 * 
	 */
	public void deleteAll();
}
