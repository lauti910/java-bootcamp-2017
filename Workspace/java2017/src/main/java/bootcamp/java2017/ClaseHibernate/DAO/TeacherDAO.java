package bootcamp.java2017.ClaseHibernate.DAO;

import java.util.List;

import bootcamp.java2017.ClaseHibernate.Model.Persons.Course;

public interface TeacherDAO {
	public void persist(Course teacher);
	public Course findById(Integer id);
	public void delete(Course teacher);
	public void update(Course teacher);
	public List<Course> getAll();
	public void deleteAll();
}
