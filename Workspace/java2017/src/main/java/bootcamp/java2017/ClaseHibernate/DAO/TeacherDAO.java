package bootcamp.java2017.ClaseHibernate.DAO;

import java.util.List;

import bootcamp.java2017.ClaseHibernate.Model.Persons.Teacher;

public interface TeacherDAO {
	public void persist(Teacher teacher);
	public Teacher findById(Integer id);
	public void delete(Teacher teacher);
	public void update(Teacher teacher);
	public List<Teacher> getAll();
	public void deleteAll();
}
