package bootcamp.java2017.ClaseHibernate.DAO;

import java.util.List;

import bootcamp.java2017.ClaseHibernate.Model.Course;

public interface CourseDAO {

	public void persist(Course course);
	public Course findById(Integer id);
	public void delete(Course course);
	public void update(Course course);
	public List<Course> getAll();
	public void deleteAll();
}
