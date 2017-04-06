package bootcamp.java2017.ClaseHibernate.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Course {

	private String name;
	private Teacher assignedTeacher;
	private Integer hoursByWeek;
	private List<Schedule> scheduleTime;
	private Map<Student, Note> notes;
	
	public Course(String name, Teacher assignedTeacher){
		this.name = name;
		this.assignedTeacher = assignedTeacher;
		this.hoursByWeek = 0;
		this.scheduleTime = new ArrayList<Schedule>();
		this.notes = new HashMap<Student,Note>();
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
		this.notes.put(student, new Note());
	}
	public void removeStudent(Student student){
		this.notes.remove(student);
	}
	public void setNoteToAnStudent(Student student, Note note){
		this.notes.put(student, note);
	}
	public Note getNotesOfTheStudent(Student student){
		return this.notes.get(student);
	}
}
