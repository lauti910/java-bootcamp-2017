package bootcamp.java2017.ClaseHibernate.DAO;

import java.util.List;

import bootcamp.java2017.ClaseHibernate.Model.Persons.Student;


public interface StudentDAO {

	/**
	 * Persist the student in the database
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
	 * @param student
	 */
	public void persist(Student student);
	/**
	 * Returns the Student with id == id
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
	 * @return Student
	 */
	public Student findById(Integer id);
	
	/**
	 * Deletes the student in the database
	 * 
	 * Should be done after you open a session, and you should close the session
	 * when you finish.
	 * Example: 
	 * 		HibernateSession.getInstance().openCurrentSessionWithTransaction();
	 * 		...
	 * 		delete(...)
	 * 		...
	 * 		HibernateSession.getInstance().closeCurrentSessionWithTransaction();
	 * @param student
	 */
	public void delete(Student student);
	
	/**
	 * Updates the student in the database
	 * 
	 * Should be done after you open a session, and you should close the session
	 * when you finish.
	 * Example: 
	 * 		HibernateSession.getInstance().openCurrentSessionWithTransaction();
	 * 		...
	 * 		update(...)
	 * 		...
	 * 		HibernateSession.getInstance().closeCurrentSessionWithTransaction();
	 * @param student
	 */
	public void update(Student student);
	
	/**
	 * Returns the list of all the students in the database
	 * 
	 * Should be done after you open a session, and you should close the session
	 * when you finish.
	 * Example: 
	 * 		HibernateSession.getInstance().openCurrentSessionWithTransaction();
	 * 		...
	 * 		getAll()
	 * 		...
	 * 		HibernateSession.getInstance().closeCurrentSessionWithTransaction();
	 * @return List<Student>
	 */
	public List<Student> getAll();
	
	/**
	 * DELETES ALL THE STUDENTS IN THE DATABASE! be careful.
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
