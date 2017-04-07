package bootcamp.java2017.ClaseHibernate.DAO;

import java.util.List;

import bootcamp.java2017.ClaseHibernate.Model.Persons.Student;


public interface StudentDAO {

	public void persist(Student student);
	public Student findById(Integer id);
	public void delete(Student student);
	public void update(Student student);
	public List<Student> getAll();
	public void deleteAll();
}
