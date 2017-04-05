package bootcamp.java2017.ClaseHibernate.Model;

import java.time.LocalDate;
import java.util.List;

public class Student extends Person{

	
	private Integer registrationNumber;
	
	public Student(String firstName, String lastName, Integer regNumber, LocalDate dateOfBirth){
		super(firstName, lastName, dateOfBirth);
		this.registrationNumber = regNumber;
	}
}
