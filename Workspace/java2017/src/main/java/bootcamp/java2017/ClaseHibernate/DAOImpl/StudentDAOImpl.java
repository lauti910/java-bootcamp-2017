package bootcamp.java2017.ClaseHibernate.DAOImpl;

import java.util.List;

import bootcamp.java2017.ClaseHibernate.DAO.StudentDAO;
import bootcamp.java2017.ClaseHibernate.Model.Course;
import bootcamp.java2017.ClaseHibernate.Model.Persons.Student;

public class StudentDAOImpl implements StudentDAO {
	private HibernateSession utils;

	
	public StudentDAOImpl(){
		this.utils = HibernateSession.getInstance();
	}
	@Override
	public void persist(Student student) {
		this.utils.getCurrentSession().persist(student);

	}

	@Override
	public Student findById(Integer id) {
		return this.utils.getCurrentSession().get(Student.class, id);

	}

	@Override
	public void delete(Student student) {
		this.utils.getCurrentSession().delete(student);
		
	}

	@Override
	public void update(Student student) {
		this.utils.getCurrentSession().update(student);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> getAll() {
		return (List<Student>) this.utils.getCurrentSession().createQuery("from Student").list();

	}

	@Override
	public void deleteAll() {
		List<Student> all = this.getAll();
		for (Student s : all) {
			this.delete(s);
		}
	}

}
