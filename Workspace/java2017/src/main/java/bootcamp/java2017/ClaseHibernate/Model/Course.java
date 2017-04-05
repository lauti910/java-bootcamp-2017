package bootcamp.java2017.ClaseHibernate.Model;

import java.util.ArrayList;
import java.util.List;

public class Course {

	private String name;
	private Teacher assignedTeacher;
	private Integer hoursByWeek;
	private List<Schedule> scheduleTime;
	private List<Student> students;
	
	public Course(String name, Teacher assignedTeacher){
		this.name = name;
		this.assignedTeacher = assignedTeacher;
		this.hoursByWeek = 0;
		this.scheduleTime = new ArrayList<Schedule>();
		this.students = new ArrayList<Student>();
	}
	
	public void addSchedule(Schedule schedule){
		this.scheduleTime.add(schedule);
		this.hoursByWeek += schedule.getAmountOfHours();
	}
	public void removeSchedule(Schedule schedule){
		this.scheduleTime.remove(schedule);
		this.hoursByWeek -= schedule.getAmountOfHours();
	}
	public void addStudent(Student student){
		this.students.add(student);
	}
	public void removeStudent(Student student){
		this.students.remove(student);
	}
}
