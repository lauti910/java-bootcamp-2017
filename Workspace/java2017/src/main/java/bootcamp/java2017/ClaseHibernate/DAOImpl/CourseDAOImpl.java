package bootcamp.java2017.ClaseHibernate.DAOImpl;

import java.util.List;


import bootcamp.java2017.ClaseHibernate.DAO.CourseDAO;
import bootcamp.java2017.ClaseHibernate.Model.Course;

public class CourseDAOImpl implements CourseDAO {
	private HibernateSession utils;

	public CourseDAOImpl(){
		this.utils = HibernateSession.getInstance();
	}
	@Override
	public void persist(Course course) {
		this.utils.getCurrentSession().persist(course);
	}

	
	@Override
	public Course findById(Integer id) {
		return this.utils.getCurrentSession().get(Course.class, id);
	}

	
	@Override
	public void delete(Course course) {
		this.utils.getCurrentSession().delete(course);

	}

	@Override
	public void update(Course course) {
		this.utils.getCurrentSession().update(course);

	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Course> getAll() {
		return (List<Course>) this.utils.getCurrentSession().createQuery("from Course").list();
	}

	
	@Override
	public void deleteAll() {
		List<Course> all = this.getAll();
		for (Course c : all) {
			this.delete(c);
		}
	}

}
