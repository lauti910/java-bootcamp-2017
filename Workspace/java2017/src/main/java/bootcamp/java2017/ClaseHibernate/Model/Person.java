package bootcamp.java2017.ClaseHibernate.Model;

import java.time.LocalDate;
import java.util.List;

public class Person {

	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;
	
	public Person(String firstName, String lastName,  LocalDate dateOfBirth){
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
	}
	
	
}
