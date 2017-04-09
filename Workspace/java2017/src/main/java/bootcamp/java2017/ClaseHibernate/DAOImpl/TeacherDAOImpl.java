package bootcamp.java2017.ClaseHibernate.DAOImpl;

import java.util.List;

import bootcamp.java2017.ClaseHibernate.DAO.TeacherDAO;
import bootcamp.java2017.ClaseHibernate.Model.Course;
import bootcamp.java2017.ClaseHibernate.Model.Persons.Teacher;

public class TeacherDAOImpl implements TeacherDAO {
	
	private HibernateSession utils;
	
	public TeacherDAOImpl(){
		this.utils = HibernateSession.getInstance();
	}
	@Override
	public void persist(Teacher teacher) {
		this.utils.getCurrentSession().persist(teacher);
		
	}

	@Override
	public Teacher findById(Integer id) {
		return this.utils.getCurrentSession().get(Teacher.class, id);
	}

	@Override
	public void delete(Teacher teacher) {
		this.utils.getCurrentSession().delete(teacher);
		
	}

	@Override
	public void update(Teacher teacher) {
		this.utils.getCurrentSession().update(teacher);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Teacher> getAll() {
		return (List<Teacher>) this.utils.getCurrentSession().createQuery("from Teacher").list();

	}

	@Override
	public void deleteAll() {
		List<Teacher> all = this.getAll();
		for (Teacher t : all) {
			this.delete(t);
		}
	}

}
